package com.shop.mapper;

import com.shop.domain.OrderDetails;
import com.shop.domain.Orders;
import com.shop.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author qsj Cotter
 * @date 2020/10/6
 */
@Repository
public interface IOrderMapper {

    /** 查询所有的订单简
     * @return
     * @throws Exception
     */
    @Select("select * from orders order by state ")
    List<Orders> findAllOrders() throws Exception;

    /** 根据用户id查询用户所有的订单
     * @return
     * @param id
     * @throws Exception
     */
    @Select("select * from orders where u_id = #{u_id} and state=0 order by o_id Desc")
    @ResultMap("map")
    List<Orders> findAllOrdersById(String id) throws Exception;

    /** 根据订单id查询订单
     * @param ordersId
     * @return
     * @throws Exception
     */
    @Select("select * from orders where o_id=#{o_id}")
    @Results(id = "map",value = {
            @Result(id = true, property = "o_id", column = "o_id"),
            @Result(property = "u_id", column = "u_id"),
            @Result(property = "totalmoney", column = "totalmoney"),
            @Result(property = "username", column = "username"),
            @Result(property = "address", column = "address"),
            @Result(property = "telephone", column = "telephone"),
            @Result(property = "paystate", column = "paystate"),
            @Result(property = "Destate", column = "Destate"),
            @Result(property = "state", column = "state"),
            @Result(property = "create_time", column = "create_time"),
            @Result(property = "orderDetailsList", column = "o_id", javaType = List.class,
                    many = @Many(select = "com.shop.mapper.IOrderMapper.findOrderDetailsByOId"))
    })
     Orders findOrderById(String ordersId) throws Exception;


    /** 根据o_id查询商品编号和数量
     * @param o_id
     * @return
     */
    @Select("select * from order_details where od_id=#{o_id}")
    @Results({
            @Result(id = true, property = "od_id", column = "od_id"),
            @Result(property = "p_id", column = "p_id"),
            @Result(property = "od_count", column = "od_count"),
            @Result(property = "product", column = "p_id", javaType = Product.class,
                    one = @One(select = "com.shop.mapper.IProductMapper.findProductId"))
    })
    List<OrderDetails> findOrderDetailsByOId(String o_id);


    /** 插入一条订单数据
     * @param orders
     * @return
     * @throws Exception
     */
    @Insert("insert into orders()" +
            "VALUES(#{o_id},#{u_id},#{totalmoney},#{address},#{telephone},#{paystate},#{create_time},#{Destate},#{state},#{username})")
    boolean insertOrder(Orders orders) throws Exception;

    /** 插入商品到订单上
     * @param orderDetails
     * @return
     * @throws Exception
     */
    @Insert("insert into order_details(od_id,p_id,od_count)" +
            "VALUES(#{od_id},#{p_id},#{od_count})")
    boolean insertOrders(OrderDetails orderDetails) throws Exception;

    /** 更新订单支付状态
     * @param orders
     * @return
     * @throws Exception
     */
    @Update("update orders set paystate= 1 where o_id=#{o_id}")
    boolean updateOrdersPayStateById(String orders) throws Exception;

    /** 更新订单发货状态
     * @param orders
     * @return
     * @throws Exception
     */
    @Update("update orders set Destate= 1 where o_id=#{o_id}")
    boolean updateOrdersDeStateById(String orders) throws Exception;

    /** 更新订单状态
     * @param orders
     * @return
     * @throws Exception
     */
    @Update("update orders set state= 0 where o_id=#{o_id}")
    boolean updateOrdersStateById(String orders) throws Exception;

    /** 用户删除订单方法
     * @param orders
     * @return
     * @throws Exception
     */
    @Update("update orders set state= 1 where o_id=#{o_id} and u_id=#{u_id}")
    boolean userDelOrders(Orders orders) throws Exception;

    /** 管理员删除订单方法
     * @param orders
     * @return
     * @throws Exception
     */
    @Delete("Delete from orders where o_id=#{o_id}")
    boolean adminDelOrders(Orders orders) throws Exception;

    /** 管理员模糊查询商品
     * @return
     * @throws Exception
     * @param orders
     */
    @Select("select * from orders where o_id like concat('%',#{o_id},'%') " +
            "or totalmoney like concat('%',#{totalmoney},'%')" +
            "or address like concat('%',#{address},'%') ")
    @ResultMap(value = "map")
    List<Orders> adminFindLikeOrders(Orders orders) throws Exception;

    /** 用户模糊查询商品
     * @return
     * @throws Exception
     * @param orders
     */
    @Select("select * from orders where o_id like concat('%',#{o_id},'%') " +
            "or totalmoney like concat('%',#{totalmoney},'%')" +
            "or address like concat('%',#{address},'%')" +
            "and u_id=#{u_id} ")
    @ResultMap(value = "map")
    List<Orders> userFindLikeOrders(Orders orders) throws Exception;
}