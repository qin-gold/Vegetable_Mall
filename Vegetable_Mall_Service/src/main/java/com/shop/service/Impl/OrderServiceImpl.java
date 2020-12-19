package com.shop.service.Impl;

import com.github.pagehelper.PageHelper;
import com.shop.domain.*;
import com.shop.mapper.IOrderMapper;
import com.shop.mapper.IProductMapper;
import com.shop.mapper.IUserMapper;
import com.shop.service.OrderService;
import com.shop.service.ShopCartService;
import com.shop.utils.OrdersUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author  qsj
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private IOrderMapper iOrderMapper;
    @Autowired
    private IUserMapper userMapper;
    @Autowired
    private ShopCartService shopCartService;
    @Autowired
    private IProductMapper iProductMapper;

    @Override
    public List<Orders> findAllOrdersById(Integer id,int pageNum,int PageSize) throws Exception {
        PageHelper.startPage(pageNum,PageSize);
        List<Orders> list = iOrderMapper.findAllOrdersById(id);
        if (list==null){
            return null;
        }
        return list;

    }

    @Override
    public List<Orders> findAllOrders(int pageNum, int PageSize) throws Exception {
        PageHelper.startPage(pageNum,PageSize);
        List<Orders> list = iOrderMapper.findAllOrders();
        if (list==null){
            return null;
        }
        return list;
    }

    @Override
    public List<Orders> userFindLikeOrders(Orders orders, int pageNum, int PageSize)   {
        PageHelper.startPage(pageNum,PageSize);
        List<Orders> list = null;
        try {
            list = iOrderMapper.userFindLikeOrders(orders);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Orders> adminFindLikeOrders(Orders orders,int pageNum, int PageSize) {
        PageHelper.startPage(pageNum,PageSize);
        List<Orders> list = null;
        try {
            list = iOrderMapper.adminFindLikeOrders(orders);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Orders findOrderById(String ordersId){
        try {
            return iOrderMapper.findOrderById(ordersId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = {ClassNotFoundException.class,NullPointerException.class, IOException.class,ArithmeticException.class})
    public Result updateOrdersById(Orders orders) throws Exception {
        Result result=new Result();
        Orders order = null;
        boolean inventory=false;
            order = iOrderMapper.findOrderById(orders.getO_id());
            Product product=new Product();
            for (OrderDetails orderDetails : order.getOrderDetailsList()) {
                product.setP_id(orderDetails.getP_id());
                if (orderDetails.getProduct().getP_inventory()>=orderDetails.getOd_count()){
                    product.setP_inventory(orderDetails.getProduct().getP_inventory()-orderDetails.getOd_count());
                    inventory = iProductMapper.updateProductInventory(product);
                }
            }
            if (inventory){
                boolean b = iOrderMapper.updateOrdersPayStateById(orders.getO_id());
                if (b){
                    result.setStateCode(200);
                    return result;
                }
            }
            result.setStateCode(500);
        return result;
    }

    @Override
    @Transactional(rollbackFor = {ClassNotFoundException.class,NullPointerException.class, IOException.class,ArithmeticException.class})
    public Result createOrder(Orders orders, Integer[] ints) throws Exception {
        Result result=new Result();
        String orderNo = OrdersUtil.getOrderNo();
        orders.setO_id(orderNo);
        orders.setCreate_time(new Timestamp(System.currentTimeMillis()));
            User user = userMapper.findUserById(orders.getU_id());
            if (orders.getUsername()==null||("").equals(orders.getUsername())||orders.getUsername().length()==0){
                orders.setUsername(user.getU_name());
            }
            if (orders.getAddress()==null||("").equals(orders.getAddress())||orders.getAddress().length()==0){
                orders.setAddress(user.getAddress());
            }
            if (orders.getTelephone()==null||("").equals(orders.getTelephone())||orders.getTelephone().length()==0){
                orders.setTelephone(user.getPhone());
            }
            orders.setPaystate(0);
            boolean insertOrder = iOrderMapper.insertOrder(orders);
            if (insertOrder){
                boolean insertOrders=false;
                OrderDetails orderDetails=new OrderDetails();
                List<ShopCart> cartList = shopCartService.findProductByuIdAndPid(user.getU_id(),ints);
                for (ShopCart shopCart : cartList) {
                    orderDetails.setOd_id(orderNo);
                    orderDetails.setOd_count(shopCart.getP_count());
                    orderDetails.setP_id(shopCart.getP_id());
                    insertOrders = iOrderMapper.insertOrders(orderDetails);
                    shopCartService.delProductToShopCart(shopCart);
                }
                if (insertOrders){
                    result.setStateCode(200);
                    result.setData(orderNo);
                    return result;
                }
            }
        result.setStateCode(500);
        return result;
    }

    @Override
    @Transactional(rollbackFor = {ClassNotFoundException.class,NullPointerException.class, IOException.class,ArithmeticException.class})
    public Result userDelOrder(Orders orders) throws Exception {
        Result result=new Result();
        boolean b = iOrderMapper.userDelOrders(orders);
        if (b){
            result.setStateCode(200);
            return result;
        }
        result.setStateCode(500);
        return result;
    }

    @Override
    @Transactional(rollbackFor = {ClassNotFoundException.class,NullPointerException.class, IOException.class,ArithmeticException.class})
    public Result adminDelOrder(Orders orders)   {
        return null;
    }

    @Override
    public Result updateOrdersPayStateById(String o_id) throws Exception {
        Result result=new Result();
        boolean b = iOrderMapper.updateOrdersPayStateById(o_id);
        if (b){
            result.setStateCode(200);
        }else {
            result.setStateCode(500);
        }
        return result;
    }

    @Override
    public Result updateOrdersDeStateById(String o_id) throws Exception {
        Result result=new Result();
        boolean b = iOrderMapper.updateOrdersDeStateById(o_id);
        if (b){
            result.setStateCode(200);
        }else {
            result.setStateCode(500);
        }
        return result;
    }

    @Override
    public Result updateOrdersStateById(String o_id) throws Exception {
        Result result=new Result();
        boolean b = iOrderMapper.updateOrdersStateById(o_id);
        if (b){
            result.setStateCode(200);
        }else {
            result.setStateCode(500);
        }
        return result;
    }


}
