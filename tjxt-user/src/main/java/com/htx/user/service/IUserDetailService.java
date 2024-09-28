package com.htx.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htx.user.domain.po.UserDetail;
import com.htx.user.domain.query.UserPageQuery;
import com.htx.common.enums.UserType;

import java.util.List;

/**
 * <p>
 * 教师详情表 服务类
 * </p>
 */
public interface IUserDetailService extends IService<UserDetail> {

    UserDetail queryById(Long userId);

    List<UserDetail> queryByIds(List<Long> ids);

    Page<UserDetail> queryUserDetailByPage(UserPageQuery pageQuery, UserType type);
}
