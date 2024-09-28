package com.htx.auth.service.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htx.auth.common.domain.PrivilegeRoleDTO;
import com.htx.auth.service.domain.po.Privilege;
import com.htx.common.domain.query.PageQuery;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 权限表，包括菜单权限和访问路径权限 服务类
 * </p>
 */
public interface IPrivilegeService extends IService<Privilege> {

    Page<Privilege> listPrivilegesByPage(PageQuery pageQuery);

    void savePrivilege(Privilege privilege);

    void removePrivilegeById(Long id);

    List<PrivilegeRoleDTO> listPrivilegeRoles();

    Set<Long> listPrivilegeByRoleId(Long roleId);

    void bindRolePrivileges(Long roleId, List<Long> privilegeIds);

    void deleteRolePrivileges(Long roleId, List<Long> privilegeIds);
}
