package com.htx.promotion.service.impl;

import com.htx.promotion.domain.po.Promotion;
import com.htx.promotion.mapper.PromotionMapper;
import com.htx.promotion.service.IPromotionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 促销活动，形式多种多样，例如：优惠券 服务实现类
 * </p>
 */
@Service
public class PromotionServiceImpl extends ServiceImpl<PromotionMapper, Promotion> implements IPromotionService {

}
