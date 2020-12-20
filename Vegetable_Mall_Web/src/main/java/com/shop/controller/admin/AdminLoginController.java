package com.shop.controller.admin;

import com.shop.domain.Admin;
import com.shop.domain.Result;
import com.shop.service.Impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * @author qsj
 */
@Controller
@RequestMapping(value = "adminLogin")
public class AdminLoginController {
    @Autowired
    private AdminServiceImpl adminService;

    @RequestMapping("in")
    public String adminIn(){
        return "admin/bgControl";
    }

    /** 管理员登录方法
     * @param model
     * @param result
     * @param admin
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/AdminLogin")
    public Result adminLogin(Model model,Result result, Admin admin, HttpSession session) {
        if (admin == null) {
            result.setStateCode(404);
            model.addAttribute("result", result);
            return result;
        }
        result = adminService.login(admin);
        session.setAttribute("admin", result.getData());
        model.addAttribute("result", result);
        return result;
    }

    /** 管理员注销方法
     * @param session
     * @return
     */
    @RequestMapping("/loginOut")
    public String adminLoginOut(HttpSession session,HttpServletResponse response) throws IOException {
        session.removeAttribute("admin");
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().print("<script>alert('您已经安全退出');window.location.href='/adminLogin/in'</script>");
        return "admin/bgControl";
    }
}
