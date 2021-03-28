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
 * 修改用户信息
 */
@Controller
@RequestMapping("/admin")
public class ModifyUserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/updateUser")
    public Result updateUser(User user, Result result) {
        try {
            if (user == null) {
                result.setStateCode(404);
                return result;
            }
            result = userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /** 查询所有存在的用户信息
     * @param model
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/findAllUser")
    public String findAllUser(Model model, @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                              @RequestParam(name = "size", required = true, defaultValue = "5") Integer size) {
        try {
            List<User> all = userService.findAllUser(page, size);
            PageInfo<User> userPageInfo = new PageInfo<>(all);
            model.addAttribute("list", userPageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/userControl";
    }

    /** 根据用户Id查询用户信息
     * @param model
     * @param user
     * @return
     */
    @RequestMapping(value = "/findUserById", params = "u_id")
    public String findUserById(Model model, User user) {
        try {
            User userById = userService.findUserById(user.getU_id());
            model.addAttribute("User", userById);
            String str = "findAllUser";
            model.addAttribute("str", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/updateUser";
    }

    /** 模糊查找
     * @param model
     * @param page
     * @param size
     * @param text
     * @return
     */
    @RequestMapping("/findLikeUser")
    public String findLikeUser(Model model, @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                               @RequestParam(name = "size", required = true, defaultValue = "5") Integer size, String text) {
        User user = new User();
        if (text == null) {
            findAllUser(model, page, size);
            return "admin/productControl";
        }
        user.setPhone(text);
        user.setU_name(text);
        user.setEmail(text);
        user.setAddress(text);
        try {
            List<User> likeUser = userService.findLikeUser(user, page, size);
            PageInfo<User> pageInfo = new PageInfo<>(likeUser);
            model.addAttribute("str", "findLikeUser");
            model.addAttribute("list", pageInfo);
            model.addAttribute("text", text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/userControl";
    }

    /** 封禁用户（逻辑删除）
     * @param user
     * @param result
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delUser0", params = "u_id")
    public Result delUser0(User user, Result result) {
        try {
            result = userService.updateUser0(user.getU_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /** 封禁用户（逻辑删除）
     * @param user
     * @param result
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delUser1", params = "u_id")
    public Result delUser1(Result result, User user) {
        try {
            result = userService.updateUser1(user.getU_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
