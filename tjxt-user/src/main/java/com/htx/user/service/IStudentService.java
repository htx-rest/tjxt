package com.htx.user.service;

import com.htx.common.domain.dto.PageDTO;
import com.htx.user.domain.dto.StudentFormDTO;
import com.htx.user.domain.query.UserPageQuery;
import com.htx.user.domain.vo.StudentPageVo;

/**
 * <p>
 * 学员详情表 服务类
 * </p>
 */
public interface IStudentService {

    void saveStudent(StudentFormDTO studentFormDTO);

    void updateMyPassword(StudentFormDTO studentFormDTO);

    PageDTO<StudentPageVo> queryStudentPage(UserPageQuery pageQuery);
}
