package com.shop.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.shop.domain.User;
import com.shop.service.UserService;
import com.shop.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author qsj
 * 修改商品信息
 */
@Controller
@RequestMapping("/admin")
public class ModifyUserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/updateUser")
    public Result updateUser(@RequestBody JSONObject jsonObject,User user,Result result) {
        try {
            user.setU_name(jsonObject.getString("u_name"));
            user.setGender(jsonObject.getString("gender"));
            user.setPhone(jsonObject.getString("phone"));
            user.setAddress(jsonObject.getString("address"));
            user.setEmail(jsonObject.getString("email"));
            result = userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/findAllUser")
    public String findAllUser(Model model, @RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                              @RequestParam(name = "size",required = true,defaultValue = "5")Integer size) {
        try {
            List<User> all = userService.findAllUser(page,size);
            PageInfo<User>userPageInfo=new PageInfo<>(all);
            model.addAttribute("list",userPageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/userControl";
    }

    @RequestMapping(value = "/findUserById",params = "u_id")
    public String findUserById(Model model,User user) {
        try {
            User userById = userService.findUserById(user.getU_id());
            model.addAttribute("User",userById);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/updateUser";
    }

    @RequestMapping("/findLikeUser")
    public String findLikeUser(Model model,@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                  @RequestParam(name = "size",required = true,defaultValue = "5")Integer size,String text){
        User user=new User();
        if (text==null){
            findAllUser(model,page,size);
            return "admin/productControl";
        }
            user.setU_name(text);
            user.setEmail(text);
            user.setAddress(text);
        try {
            List<User> likeUser = userService.findLikeUser(user, page, size);
            PageInfo<User> pageInfo=new PageInfo<>(likeUser);
            model.addAttribute("list",pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/userControl";
    }
}
