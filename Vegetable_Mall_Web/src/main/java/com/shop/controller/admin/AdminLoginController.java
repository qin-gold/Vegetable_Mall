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

    /**
     * 登录方法
     * @param model
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public Result adminLogin(Model model, HttpServletRequest request, HttpSession session) {
        Result result = new Result();
        if (request == null) {
            result.setStateCode(404);
            result.setMsg("不能输入为空");
            model.addAttribute("result", result);
            return result;
        }
        Admin admin = new Admin();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        admin.setA_username(username);
        admin.setA_password(password);
        result = adminService.login(admin);
        session.setAttribute("admin", result.getData());
        Object attribute = session.getAttribute("admin");
        model.addAttribute("result", result);
        return result;
    }

    /**
     * 注销方法
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
