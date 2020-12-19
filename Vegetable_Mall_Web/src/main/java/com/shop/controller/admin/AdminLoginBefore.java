package com.shop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author qsj
 */
@Controller
@RequestMapping("/admin")
public class AdminLoginBefore {

    @RequestMapping("/control")
    public String control(){
        return "/admin/control";
    }
}
