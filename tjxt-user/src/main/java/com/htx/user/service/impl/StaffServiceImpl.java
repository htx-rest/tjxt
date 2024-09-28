package com.htx.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.htx.api.cache.RoleCache;
import com.htx.common.domain.dto.PageDTO;
import com.htx.common.enums.UserType;
import com.htx.common.utils.BeanUtils;
import com.htx.user.domain.po.UserDetail;
import com.htx.user.domain.query.UserPageQuery;
import com.htx.user.domain.vo.StaffVO;
import com.htx.user.service.IStaffService;
import com.htx.user.service.IUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工详情表 服务实现类
 * </p>
 */
@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements IStaffService {

    private final IUserDetailService detailService;
    private final RoleCache roleCache;
    @Override
    public PageDTO<StaffVO> queryStaffPage(UserPageQuery query) {
        // 1.搜索
        Page<UserDetail> p = detailService.queryUserDetailByPage(query, UserType.STAFF);
        // 2.处理vo
        return PageDTO.of(p, u -> {
            StaffVO v = BeanUtils.toBean(u, StaffVO.class);
            v.setRoleName(roleCache.getRoleName(u.getRoleId()));
            return v;
        });
    }
}
