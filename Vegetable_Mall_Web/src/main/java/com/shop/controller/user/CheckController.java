package com.shop.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.shop.domain.User;
import com.shop.service.UserService;
import com.shop.utils.EmailUtil;
import com.shop.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @author qsj
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class CheckController {
    @Autowired
    private UserService userService;

    /**
     * 检查邮箱是否存在发送验证码
     * @param jsonObject
     * @return Result
     */
    @PostMapping("/checkEmail")
    public Result check(@RequestBody JSONObject jsonObject) throws Exception{
        String email = jsonObject.getString("email");
        Result result = userService.findEmail(email);
        if (result.getStateCode()==200){
            EmailUtil emailUtil=new EmailUtil();
            String port = emailUtil.EmailPort(email);
            result.setData(port);
        }
        return result;
    }

    /**
     * 检查邮箱是否存在
     * @param jsonObject
     * @return Result
     */
    @PostMapping("/checkEmailExist")
    public Result checkEmail(@RequestBody JSONObject jsonObject) throws Exception{
        String email = jsonObject.getString("email");
        Result result = userService.findEmail(email);
        return result;
    }

    /**
     * 检查电话号码是否存在
     * @param jsonObject
     * @return Result
     */
    @PostMapping("/checkNumberExist")
    public Result checkNumberExist(@RequestBody JSONObject jsonObject, Result result) throws Exception{
        String phone = jsonObject.getString("phone");
        result = userService.findUserByPhone(phone);
        System.out.println(result);
        return result;
    }

    /**
     * 忘记密码
     * @param jsonObject
     * @return Result
     */
    @Transactional
    @PostMapping("/updatePassword")
    public Result updateUser(@RequestBody JSONObject jsonObject, Result result) throws Exception {
        String email=jsonObject.getString("email");
        String password = jsonObject.getString("password");
        User user=new User();
        user.setEmail(email);
        user.setU_password(password);
        if (email!=null||password!=null){
            result = userService.updateUserPassword(user);
            return result;
        }else {
            result.setStateCode(500);
            return result;
        }
    }
}
