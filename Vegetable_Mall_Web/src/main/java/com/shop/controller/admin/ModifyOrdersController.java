package com.shop.controller.admin;

import com.github.pagehelper.PageInfo;
import com.shop.domain.Orders;
import com.shop.domain.Result;
import com.shop.service.OrderService;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author qsj
 * 修改订单信息
 */
@Controller
@RequestMapping("/admin")
public class ModifyOrdersController {
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/findAllOrders")
    public String findAllOrders(Model model, @RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                              @RequestParam(name = "size",required = true,defaultValue = "5")Integer size) {
        try {
            List<Orders> all = orderService.findAllOrders(page,size);
            PageInfo<Orders>OrdersPageInfo=new PageInfo<>(all);
            model.addAttribute("list",OrdersPageInfo);
            String str="findAllOrders";
            model.addAttribute("str", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/OrdersControl";
    }

    @RequestMapping(value = "/findOrdersById",params = "o_id")
    public String findUserById(Model model,Orders orders) {
        try {
            Orders order = orderService.findOrderById(orders.getO_id());
            model.addAttribute("orders",order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/OrdersIframe";
    }

    @RequestMapping("/findLikeOrders")
    public String findLikeOrders(Model model,@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                  @RequestParam(name = "size",required = true,defaultValue = "5")Integer size,String text){
        Orders orders=new Orders();
        if (text==null){
            findAllOrders(model,page,size);
            return "admin/OrdersControl";
        }
            orders.setO_id(text);
            orders.setAddress(text);
            orders.setUsername(text);
        try {
            List<Orders> list = orderService.adminFindLikeOrders(orders, page, size);
            PageInfo<Orders> pageInfo=new PageInfo<>(list);
            String str="findLikeOrders";
            model.addAttribute("str", str);
            model.addAttribute("list",pageInfo);
            model.addAttribute("text",text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/OrdersControl";
    }

    @ResponseBody
    @RequestMapping(value = "/updatePayState",params = "o_id")
    public Result updatePayState(Orders orders,Result result) {
        try {
            result = orderService.updateOrdersPayStateById(orders.getO_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/updateDeState",params = "o_id")
    public Result updateDeState(Orders orders,Result result) {
        try {
            result = orderService.updateOrdersDeStateById(orders.getO_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/updateState",params = "o_id")
    public Result updateState(Orders orders,Result result) {
        try {
            result = orderService.updateOrdersStateById(orders.getO_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
