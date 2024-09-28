package com.htx.promotion.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htx.common.utils.CollUtils;
import com.htx.promotion.constants.ScopeType;
import com.htx.promotion.domain.po.CouponScope;
import com.htx.promotion.strategy.scope.Scope;
import com.htx.promotion.mapper.CouponScopeMapper;
import com.htx.promotion.service.ICouponScopeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 优惠券作用范围信息 服务实现类
 * </p>
 */
@Service
@RequiredArgsConstructor
public class CouponScopeServiceImpl extends ServiceImpl<CouponScopeMapper, CouponScope> implements ICouponScopeService {

    @Override
    public void removeByCouponId(Long couponId) {
        remove(new LambdaQueryWrapper<CouponScope>().eq(CouponScope::getCouponId, couponId));
    }

    @Override
    public List<Scope> queryScopeByCouponId(Long couponId) {
        // 1.查询范围
        List<CouponScope> scopes = lambdaQuery()
                .eq(CouponScope::getCouponId, couponId)
                .list();
        // 2.非空处理
        if (CollUtils.isEmpty(scopes)) {
            return CollUtils.emptyList();
        }
        // 3.数据分组
        Map<Integer, List<Long>> scopeMap = scopes.stream().collect(
                Collectors.groupingBy(
                        CouponScope::getType,
                        Collectors.flatMapping(c -> Stream.of(c.getBizId()), Collectors.toList())));
        // 4.查询范围详细数据
        List<Scope> list = new ArrayList<>(scopeMap.size());
        for (Map.Entry<Integer, List<Long>> en : scopeMap.entrySet()) {
            list.add(ScopeType.of(en.getKey()).buildScope(en.getValue()));
        }
        return list;
    }
}
