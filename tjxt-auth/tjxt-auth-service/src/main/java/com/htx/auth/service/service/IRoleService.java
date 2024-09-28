package com.htx.auth.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.htx.auth.service.domain.po.Role;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 */
public interface IRoleService extends IService<Role> {

    boolean exists(Long roleId);
    boolean exists(List<Long> roleIds);

    void deleteRole(Long id);
}
