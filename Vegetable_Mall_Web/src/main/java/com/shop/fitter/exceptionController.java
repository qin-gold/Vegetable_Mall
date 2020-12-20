package com.shop.fitter;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/** 处理404
 * @author 84735
 */
@ControllerAdvice
public class exceptionController {
@ExceptionHandler({ClassNotFoundException.class, FileNotFoundException.class})//要处理的异常
public String handleException(Model model,HttpServletRequest request){
    //传入我们自己的错误状态码  404
    request.setAttribute("javax.servlet.error.status_code",500);
    model.addAttribute("javax.servlet.error.status_code",500);
    //转发到/error
    return "public/error";
}
}
