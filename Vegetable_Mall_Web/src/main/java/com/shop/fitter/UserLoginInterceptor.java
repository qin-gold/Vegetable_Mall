package com.shop.fitter;


import com.shop.domain.Admin;
import com.shop.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author qsj
 */
public class UserLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String type=request.getHeader("X-Requested-With")==null ? "" : request.getHeader("X-Requested-With");
        HttpSession session=request.getSession();
        User user = (User)session.getAttribute("user");
        if (user!=null){
            if (user.getU_name()!=null){
                return true;
                }
            }else {
            if("XMLHttpRequest".equals(type)) {
                //处理AJAX请求，设置响应头信息
                response.setHeader("REDIRECT", "REDIRECT");
                response.setHeader("CONTEXTPATH", request.getContextPath()+"/login");
            } else {
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().print("<script>alert('请先登录再进行访问');window.location.href='/login'</script>");
            }
        }
        return false;
    }
}
