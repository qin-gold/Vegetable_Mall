package com.shop.fitter;

import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/** 处理404
 * @author 84735
 */
@ControllerAdvice
public class ExceptionController {
@ExceptionHandler({ClassNotFoundException.class, FileNotFoundException.class ,NullPointerException.class})//要处理的异常
public String handle1Exception(Model model,HttpServletRequest request){
    //传入我们自己的错误状态码  404
    model.addAttribute("errorCode",404);
    //转发到/error
    return "public/error";
}
    @ExceptionHandler({SpelEvaluationException.class, IOException.class, MaxUploadSizeExceededException.class})//要处理的异常
    public String handle2Exception(Model model,HttpServletRequest request){
        //传入我们自己的错误状态码  500
        model.addAttribute("errorCode",500);
        //转发到/error
        return "public/error";
    }
}
