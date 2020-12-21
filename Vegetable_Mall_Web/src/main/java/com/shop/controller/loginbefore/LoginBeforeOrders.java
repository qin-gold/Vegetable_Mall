package com.shop.controller.loginbefore;

import com.github.pagehelper.PageInfo;
import com.shop.domain.*;
import com.shop.service.OrderService;
import com.shop.service.ShopCartService;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author qsj
 */
@Controller
@RequestMapping("/loginBefore")
public class LoginBeforeOrders {
    @Autowired
    private ShopCartService shopCartService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @RequestMapping("/payFor")
    public String payFor(Model model,Orders orders){
        try {
            Orders order = orderService.findOrderById(orders.getO_id());
            model.addAttribute("order",order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "loginBefore/payFor";
    }

    @RequestMapping("/ordersView")
    public String ordersView(Model model,HttpSession session,@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                             @RequestParam(name = "size", required = true, defaultValue = "3") Integer size){
        User user = (User)session.getAttribute("user");
        try {
            List<Orders> list = orderService.findAllOrdersById(user.getU_id(),page,size);
            PageInfo<Orders> pageInfo = new PageInfo<>(list);
            String str="ordersView";
            model.addAttribute("list",pageInfo);
            model.addAttribute("str", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "loginBefore/ordersView";
    }

    @RequestMapping("/findLikeOrders")
    public String findLikeOrders(Model model,HttpSession session,@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                               @RequestParam(name = "size",required = true,defaultValue = "3")Integer size,String text){
        Orders orders=new Orders();
        if (text==null){
            ordersView(model,session,page,size);
            return "loginBefore/ordersView";
        }
        User user = (User)session.getAttribute("user");
        orders.setU_id(user.getU_id());
        orders.setO_id(text);
        orders.setAddress(text);
        orders.setUsername(text);
        try {
            List<Orders> list = orderService.userFindLikeOrders(orders, page, size);
            PageInfo<Orders> pageInfo=new PageInfo<>(list);
            String str="findLikeOrders";
            model.addAttribute("list",pageInfo);
            model.addAttribute("str", str);
            model.addAttribute("text", text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "loginBefore/ordersView";
    }
    @ResponseBody
    @RequestMapping("/payDone")
    public Result payDone(Orders orders){
        Result result=new Result();
        try {
            result = orderService.updateOrdersById(orders);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/checkOut")
    public String checkOut(Model model, Integer[] p_id , HttpSession session){
        User user = (User)session.getAttribute("user");
        User userById=null;
        List<ShopCart> cartList=null;
            try {
               cartList = shopCartService.findProductByuIdAndPid(user.getU_id(), p_id);
               userById= userService.findUserById(user.getU_id());
            } catch (Exception e) {
                e.printStackTrace();
            }
            model.addAttribute("product",cartList);
            model.addAttribute("user",userById);
            return "loginBefore/checkOut";
    }

    @ResponseBody
    @RequestMapping("/createOrders")
    public Result createOrders(Integer[] p_id,HttpSession session,Orders orders){
        Result result=new Result();
        User user = (User) session.getAttribute("user");
        orders.setU_id(user.getU_id());
        try {
            result= orderService.createOrder(orders, p_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/userDelOrder")
    public Result userDelOrder(HttpSession session, Result result,Orders order){
            try {
                User user = (User)session.getAttribute("user");
                order.setU_id(user.getU_id());
                result= orderService.userDelOrder(order);
            } catch (Exception e) {
                e.printStackTrace();
                result.setStateCode(500);
            }
        return result;
    }
}
