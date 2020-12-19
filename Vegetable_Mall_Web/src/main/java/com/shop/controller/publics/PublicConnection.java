package com.shop.controller.publics;

import com.github.pagehelper.PageInfo;
import com.shop.domain.Product;
import com.shop.domain.User;
import com.shop.service.ProductService;
import com.shop.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author qsj
 */
@Controller
public class PublicConnection {
    @Autowired
    private ProductService productService;
    @Autowired
    private ShopCartService shopCartService;

    /** 首页
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (user!=null){
            Integer total = shopCartService.findProductTotal(user.getU_id());
            model.addAttribute("model",total);
        }
        try {
            List<Product> list = productService.findHotProduct();
            model.addAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "public/index";
    }

    /** 登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "user/login";
    }

    /** 注册页面
     * @return
     */
    @RequestMapping("/register")
    public String register(){
        return "user/register";
    }

    /** 忘记密码页面
     * @return
     */
    @RequestMapping("/forgetPassword")
    public String forgetPassword(){
        return "user/forgetPassword";
    }

    /** 乳制品页面
     * @return
     */
    @RequestMapping("/dairy")
    public String dairy(Model model,HttpServletRequest request,
                            @RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                            @RequestParam(name = "size",required = true,defaultValue = "8")Integer size){
        try {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            if (user!=null){
                Integer total = shopCartService.findProductTotal(user.getU_id());
                model.addAttribute("model",total);
            }
            List<Product> productByType = productService.findProductByType(6, page, size);
            PageInfo<Product> pageInfo=new PageInfo(productByType);
            model.addAttribute("pageInfo",pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "public/dairy";
    }

    /** 蔬菜页面
     * @param model
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/vegetables")
    public String vegetables(Model model,HttpServletRequest request,
                             @RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                             @RequestParam(name = "size",required = true,defaultValue = "8")Integer size){
        try {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            if (user!=null){
                Integer total = shopCartService.findProductTotal(user.getU_id());
                model.addAttribute("model",total);
            }
            List<Product> productByType = productService.findProductByType(4, page, size);
            PageInfo<Product> pageInfo=new PageInfo(productByType);
            model.addAttribute("pageInfo",pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "public/vegetables";
    }

    /** 水果页面
     * @return
     */
    @RequestMapping("/fruit")
    public String fruit(Model model,HttpServletRequest request,
                             @RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                             @RequestParam(name = "size",required = true,defaultValue = "8")Integer size){
        try {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            if (user!=null){
                Integer total = shopCartService.findProductTotal(user.getU_id());
                model.addAttribute("model",total);
            }
            List<Product> productByType = productService.findProductByType(3, page, size);
            PageInfo<Product> pageInfo=new PageInfo(productByType);
            model.addAttribute("pageInfo",pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "public/fruit";
    }

    /** 肉类页面
     * @return
     */
    @RequestMapping("/meat")
    public String meat(Model model,HttpSession session,
                            @RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                            @RequestParam(name = "size",required = true,defaultValue = "8")Integer size){
        try {
            User user = (User)session.getAttribute("user");
            if (user!=null){
                Integer total = shopCartService.findProductTotal(user.getU_id());
                model.addAttribute("model",total);
            }
            List<Product> productByType = productService.findProductByType(2, page, size);
            PageInfo<Product> pageInfo=new PageInfo(productByType);
            model.addAttribute("pageInfo",pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "public/meat";
    }

    /** 搜索页面
     * @return
     */
    @RequestMapping("/search")
    public String search(Model model,HttpSession session,Product product,String text,
                       @RequestParam(name = "page",defaultValue = "1")Integer page,
                       @RequestParam(name = "size",defaultValue = "8")Integer size){
        try {
            User user = (User)session.getAttribute("user");
            if (user!=null){
                Integer total = shopCartService.findProductTotal(user.getU_id());
                model.addAttribute("model",total);
            }
            product.setP_name(text);
            product.setP_overview(text);
            List<Product> productByType = productService.findLikeProduct(product,page,size);
            PageInfo<Product> pageInfo=new PageInfo(productByType);
            model.addAttribute("pageInfo",pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "public/search";
    }

    /** 商品详细页面
     * @return
     */
    @RequestMapping("/detail")
    public String detail(Model model,HttpServletRequest request,
                         @RequestParam(name = "p_id")Integer p_id){
        if (p_id<=0){
            return "public/index";
        }
        Product product = null;
        try {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            if (user!=null){
                Integer total = shopCartService.findProductTotal(user.getU_id());
                model.addAttribute("model",total);
            }
            product = productService.findProductId(p_id);
            List<Product> list = productService.findHotProduct();
            model.addAttribute("product",product);
            model.addAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            return "public/index";
        }
        return "public/detail";
    }

}
