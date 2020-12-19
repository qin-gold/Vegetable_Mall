package com.shop.controller.loginbefore;

import com.shop.domain.Product;
import com.shop.domain.Result;
import com.shop.domain.ShopCart;
import com.shop.domain.User;
import com.shop.service.ProductService;
import com.shop.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author qsj
 */
@Controller
@RequestMapping("/loginBefore")
public class LoginBeforeShopingCart {
    @Autowired
    private ShopCartService cartService;

    @Autowired
    private ProductService productService;

    /** 购物车页面
     * @return
     */
    @RequestMapping("/shoppingCartTotal")
    public String shoppingCartTotal(HttpSession session,Model model){
        User user = (User)session.getAttribute("user");
        List<ShopCart> carts = cartService.findProductByuId(user.getU_id());
        model.addAttribute("cart",carts);
        return "loginBefore/shoppingCart";
    }

    /** 购物车页面
     * @return
     */
    @RequestMapping("/shoppingCart")
    public String shoppingCart(HttpSession session,Model model){
        User user = (User)session.getAttribute("user");
        List<ShopCart> carts = cartService.findProductByuId(user.getU_id());
        model.addAttribute("cart",carts);
        List<Product> list = null;
        try {
            list = productService.findHotProduct();
            model.addAttribute("list",list);
        } catch (Exception e) {
        }
        return "loginBefore/shoppingCart";
    }

    /** 添加商品到购物车
     * @return
     */
    @ResponseBody
    @RequestMapping("/addToShoppingCart")
    public Result addToShoppingCart(ShopCart shopCart, HttpSession session , Result result){
        User user = (User)session.getAttribute("user");
        shopCart.setU_id(user.getU_id());
        result = cartService.saveProductToShopCart(shopCart);
        return result;
    }

    /** 更新购物车商品
     * @param shopCart
     * @param session
     * @param result
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateProduct")
    public Result updateProduct(ShopCart shopCart,HttpSession session,Result result ){
        User user = (User)session.getAttribute("user");
        shopCart.setU_id(user.getU_id());
        result = cartService.updateProductToShopCart(shopCart);
        return result;
    }

    /** 删除购物车商品
     * @param shopCart
     * @param session
     * @param result
     * @return
     */
    @ResponseBody
    @RequestMapping("/delProduct")
    public Result delProduct(ShopCart shopCart,HttpSession session,Result result ){
        User user = (User)session.getAttribute("user");
        shopCart.setU_id(user.getU_id());
        result = cartService.delProductToShopCart(shopCart);
        return result;
    }

    /** 清空购物车商品
     * @param session
     * @param result
     * @return
     */
    @ResponseBody
    @RequestMapping("/EmptyShopCart")
    public Result delProduct(HttpSession session,Result result ){
        User user = (User)session.getAttribute("user");
        if (user.getU_id()!=null){
        result = cartService.EmptyShopCartByuId(user.getU_id());
        }else {
            result.setStateCode(500);
        }
        return result;
    }
}
