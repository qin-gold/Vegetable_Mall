package com.shop.service;

import com.shop.domain.Orders;
import com.shop.domain.Result;

import java.util.List;

/**
 *
 * @author qsj Cotter
 * @date 2020/10/7
 */
public interface OrderService {

    /** 管理员查询所有
     * @param pageNum
     * @param PageSize
     * @return
     * @throws Exception
     */
    List<Orders> findAllOrders(int pageNum,int PageSize) throws Exception;

    /** 管理员模糊查询
     * @param orders
     * @param pageNum
     * @param PageSize
     * @return
     * @throws Exception
     */
    List<Orders> adminFindLikeOrders(Orders orders,int pageNum,int PageSize) throws Exception;

    /** 用户查询所有订单
     * @param id
     * @param pageNum
     * @param PageSize
     * @return
     * @throws Exception
     */
    List<Orders> findAllOrdersById(Integer id,int pageNum,int PageSize) throws Exception;

    /**  用户模糊查询所有
     * @param orders
     * @param pageNum
     * @param PageSize
     * @return
     * @throws Exception
     */
    List<Orders> userFindLikeOrders(Orders orders,int pageNum,int PageSize) throws Exception;

    /** 根据id查找数据
     * @param ordersId
     * @return
     * @throws Exception
     */
    Orders findOrderById(String ordersId) throws Exception;

    /** 修改订单方法
     * @param orders
     * @return
     * @throws Exception
     */
    Result updateOrdersById(Orders orders) throws Exception;

    /** 新增订单
     * @param orders
     * @param ints
     * @return
     * @throws Exception
     */
    Result createOrder(Orders orders, Integer[] ints) throws Exception;

    /** 用户删除订单方法
     * @param orders
     * @return
     * @throws Exception
     */
    Result userDelOrder(Orders orders)throws Exception;

    /** 管理员删除订单方法
     * @param orders
     * @return
     * @throws Exception
     */
    Result adminDelOrder(Orders orders)throws Exception;

    /** 管理员修改订单发货状态方法
     * @param orders
     * @return
     * @throws Exception
     */
    Result updateOrdersPayStateById(String orders)throws Exception;

    /** 管理员修改订单发货状态方法
     * @param orders
     * @return
     * @throws Exception
     */
    Result updateOrdersDeStateById(String orders)throws Exception;

    /** 管理员修改订单状态方法
     * @param orders
     * @return
     * @throws Exception
     */
    Result updateOrdersStateById(String orders)throws Exception;

}
