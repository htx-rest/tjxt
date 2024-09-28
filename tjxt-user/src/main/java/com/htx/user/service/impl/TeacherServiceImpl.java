package com.htx.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.htx.api.client.course.CourseClient;
import com.htx.api.dto.course.SubNumAndCourseNumDTO;
import com.htx.common.domain.dto.PageDTO;
import com.htx.common.utils.BeanUtils;
import com.htx.user.domain.po.UserDetail;
import com.htx.user.domain.query.UserPageQuery;
import com.htx.user.domain.vo.TeacherPageVO;
import com.htx.common.enums.UserType;
import com.htx.user.service.ITeacherService;
import com.htx.user.service.IUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 教师详情表 服务实现类
 * </p>
 */
@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private IUserDetailService detailService;
    @Autowired
    private CourseClient courseClient;

    @Override
    public PageDTO<TeacherPageVO> queryTeacherPage(UserPageQuery pageQuery) {
        // 1.分页参数
        Page<UserDetail> page = detailService.queryUserDetailByPage(pageQuery, UserType.TEACHER);
        // 2.处理返回值
        List<UserDetail> records = page.getRecords();
        // 2.1.查询老师的试题数量、课程数量
        List<Long> ids = records.stream().map(UserDetail::getId).collect(Collectors.toList());
        List<SubNumAndCourseNumDTO> countDTOs = courseClient.infoByTeacherIds(ids);
        Map<Long, SubNumAndCourseNumDTO> map = countDTOs.stream()
                .collect(Collectors.toMap(SubNumAndCourseNumDTO::getTeacherId, s -> s));
        // 2.2.数据转换
        List<TeacherPageVO> list = new ArrayList<>(records.size());
        for (UserDetail record : records) {
            TeacherPageVO teacherPageVO = BeanUtils.toBean(record, TeacherPageVO.class);
            SubNumAndCourseNumDTO sc = map.get(teacherPageVO.getId());
            teacherPageVO.setCourseAmount(sc.getCourseNum());
            teacherPageVO.setExamQuestionAmount(sc.getSubjectNum());
            list.add(teacherPageVO);
        }
        return new PageDTO<>(page.getTotal(), page.getPages(), list);
    }
}
