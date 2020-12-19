package com.shop.fitter;


import com.shop.domain.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author qsj
 */
public class AdminLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        Admin admin = (Admin)session.getAttribute("admin");
        if (admin!=null){
            if (admin.getA_username()!=null){
                return true;
            }
        }
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().print("<script>alert('请先登录再进行访问');window.location.href='/adminLogin/in'</script>");
        return false;
    }
}
