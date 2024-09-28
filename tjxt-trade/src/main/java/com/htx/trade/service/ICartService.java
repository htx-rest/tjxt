package com.htx.trade.service;

import com.htx.trade.domain.po.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htx.trade.domain.vo.CartVO;

import java.util.List;

/**
 * <p>
 * 购物车条目信息，也就是购物车中的课程 服务类
 * </p>
 */
public interface ICartService extends IService<Cart> {

    void addCourse2Cart(Long courseId);

    List<CartVO> getMyCarts();

    void deleteCartById(Long id);

    void deleteCartByIds(List<Long> ids);

    void deleteCartByUserAndCourseIds(Long userId, List<Long> courseIds);
}
