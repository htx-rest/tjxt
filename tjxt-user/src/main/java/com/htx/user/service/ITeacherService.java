package com.htx.user.service;

import com.htx.common.domain.dto.PageDTO;
import com.htx.user.domain.query.UserPageQuery;
import com.htx.user.domain.vo.TeacherPageVO;

/**
 * <p>
 * 教师详情表 服务类
 * </p>
 */
public interface ITeacherService{
    PageDTO<TeacherPageVO> queryTeacherPage(UserPageQuery pageQuery);

}
