package com.shop.controller.user;

import com.shop.domain.Result;
import com.shop.domain.User;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author qsj
 */
@Controller
@RequestMapping("/loginBefore")
public class UserInformation {
    @Autowired
    private UserService userService;

    @RequestMapping("/information")
    public String information(Model model,HttpSession session,User user){
        User userDate = (User)session.getAttribute("user");
        try {
            user = userService.findUserById(userDate.getU_id());
            model.addAttribute("user",user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user/information";
    }
    @ResponseBody
    @RequestMapping("/updateUser")
    public Result updateUser(Result result, HttpSession session, User user){
        System.out.println(user);
        User userDate = (User)session.getAttribute("user");
        user.setU_id(userDate.getU_id());
        try {
            result = userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
