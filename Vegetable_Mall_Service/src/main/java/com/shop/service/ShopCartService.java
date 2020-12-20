package com.shop.service;

import com.shop.domain.Result;
import com.shop.domain.ShopCart;

import java.util.List;

/**
 *
 * @author qsj Cotter
 * @date 2020/10/7
 */
public interface ShopCartService {

    /**根据用户名查找购物车
     * @param u_id
     * @return
     */
    List<ShopCart> findProductByuId(String u_id);

    /**根据用户id和商品id查找购物车
     * @param u_id
     * @param p_id
     * @return
     */
    List<ShopCart> findProductByuIdAndPid(String u_id,Integer[] p_id);

    /** 添加商品到购物车
     * @param shopCart
     * @return
     */
    Result saveProductToShopCart(ShopCart shopCart);

    /** 更新购物车商品
     * @param shopCart
     * @return
     */
    Result updateProductToShopCart(ShopCart shopCart);

    /** 删除购物车商品
     * @param shopCart
     * @return
     */
    Result delProductToShopCart(ShopCart shopCart);

    /** 查询购物车商品总数
     * @param u_id
     * @return
     */
    Integer findProductTotal(String u_id);

    /** 清空购物车中的商品
     * @param u_id
     * @return
     */
    Result EmptyShopCartByuId(String u_id);
}
