package com.shop.mapper;

import com.shop.domain.Product;
import com.shop.domain.ShopCart;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qsj
 */
@Repository
public interface IShopCartMapper {

    /** 根据用户id查询购物车全部数据
     * @param u_id
     * @return
     * @throws Exception
     */
    @Select("Select * from shop_cart where u_id=#{u_id}")
    @Results(value = {
            @Result(id = true,property = "sc_id",column = "sc_id"),
            @Result(property = "u_id",column = "u_id"),
            @Result(property = "p_id",column = "p_id"),
            @Result(property = "p_count",column = "p_count"),
            @Result(property = "product",column = "p_id",
                    many = @Many(select = "com.shop.mapper.IShopCartMapper.findProductBySc_id"))
            }
    )
    List<ShopCart> findProductByu_idf(Integer u_id)throws Exception;

    /** 根据用户id和p_id查询数据
     * @param u_id
     * @return
     * @throws Exception
     */
    @Select("Select * from shop_cart where u_id=#{arg0} and p_id=#{arg1}")
    @Results(value = {
            @Result(id = true,property = "sc_id",column = "sc_id"),
            @Result(property = "u_id",column = "u_id"),
            @Result(property = "p_id",column = "p_id"),
            @Result(property = "p_count",column = "p_count"),
            @Result(property = "product",column = "p_id",
                    one = @One(select = "com.shop.mapper.IShopCartMapper.findProductBySc_id"))
    }
    )
    ShopCart findProductByu_idp_id(Integer u_id,Integer p_id)throws Exception;

    /** 根据购物车Id寻找商品
     * @param p_id
     * @return
     */
    @Select("select p.p_name,p.p_price from product as p where p_id=#{p_id}")
    Product findProductBySc_id(Integer p_id);

    /** 根据用户id查询购物车商品Id
     * @param u_id
     * @return
     * @throws Exception
     */
    @Select("Select p_id from shop_cart where u_id=#{u_id}")
    List<ShopCart> findProductByu_idj(Integer u_id)throws Exception;

    /** 添加商品到购物车
     * @param shopCart
     * @return
     * @throws Exception
     */
    @Insert("insert into shop_cart(u_id,p_id,p_count)VALUES(#{u_id},#{p_id},#{p_count})")
    Integer saveProductToShopCart(ShopCart shopCart)throws Exception;

    /** 判断是否更新购物车数据
     * @param shopCart
     * @return
     * @throws Exception
     */
    @Update("UPDATE shop_cart SET p_count=p_count+#{p_count} WHERE u_id=#{u_id} AND p_id =#{p_id}")
    Integer IfUpdateProductToShopCart(ShopCart shopCart)throws Exception;

    /** 更新购物车数据
     * @param shopCart
     * @return
     * @throws Exception
     */
    @Update("UPDATE shop_cart SET p_count=#{p_count} WHERE u_id=#{u_id} AND p_id =#{p_id}")
    Integer updateProductToShopCart(ShopCart shopCart)throws Exception;

    /** 删除购物车数据
     * @param shopCart
     * @return
     * @throws Exception
     */
    @Delete("delete from shop_cart WHERE u_id=#{u_id} AND p_id =#{p_id}")
    Integer delProductToShopCart(ShopCart shopCart)throws Exception;

    /** 查询购物车总条数数据
     * @param u_id
     * @return
     * @throws Exception
     */
    @Select("select Count(sc_id) from shop_cart WHERE u_id=#{u_id}")
    Integer findProductTotal(Integer u_id)throws Exception;

}
