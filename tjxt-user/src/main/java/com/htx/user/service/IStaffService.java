package com.htx.user.service;

import com.htx.common.domain.dto.PageDTO;
import com.htx.user.domain.query.UserPageQuery;
import com.htx.user.domain.vo.StaffVO;

/**
 * <p>
 * 员工详情表 服务类
 * </p>
 */
public interface IStaffService {
    PageDTO<StaffVO> queryStaffPage(UserPageQuery pageQuery);
}
