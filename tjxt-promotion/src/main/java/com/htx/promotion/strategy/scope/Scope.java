package com.htx.promotion.strategy.scope;

import com.tianji.api.dto.promotion.OrderCourseDTO;
import com.htx.promotion.constants.ScopeType;

import java.util.List;

public interface Scope {

    boolean canUse(OrderCourseDTO course);

    ScopeType getType();

    List<Long> getScopeIds();
}
