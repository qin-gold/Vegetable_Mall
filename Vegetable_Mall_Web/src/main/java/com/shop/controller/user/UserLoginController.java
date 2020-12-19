package com.shop.controller.user;

import com.shop.domain.Result;
import com.shop.domain.User;
import com.shop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author qsj
 */
@Controller
@RequestMapping("/user")
public class UserLoginController {
    @Autowired
    private LoginService loginService;

    /** 登录方法
     * @param model
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public Result Login(Model model, HttpServletRequest request, HttpSession session){
        Result result=new Result();
        if (request==null){
            result.setStateCode(404);
            result.setMsg("不能输入为空");
            model.addAttribute("result",result);
            return result;
        }
        String emailOrNumber = request.getParameter("emailOrNumber");
        String u_password = request.getParameter("password");
        User user=new User();
        user.setEmail(emailOrNumber);
        user.setPhone(emailOrNumber);
        user.setU_password(u_password);
        try {
             result = loginService.loginIn(user);
             model.addAttribute("result",result);
             session.setAttribute("user",result.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
            return result;
    }

    /** 注册方法
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/register")
    public Result register(User user,Result result){
            result = loginService.SaveUser(user);
            return result;
    }

    /** 注销方法
     * @param session
     * @return
     */
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.removeAttribute("user");
        return "public/index";
    }
}
