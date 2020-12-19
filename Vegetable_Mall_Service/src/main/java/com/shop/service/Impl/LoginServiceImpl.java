package com.shop.service.Impl;

import com.shop.domain.User;
import com.shop.mapper.IUserMapper;
import com.shop.service.LoginService;
import com.shop.domain.Result;
import com.shop.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author qsj
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private IUserMapper iUserMapper;


    @Override
    @Transactional
    public Result loginIn(User userData) throws Exception {
        Result result = new Result();
        String md5 = MD5.ToMD5(userData.getU_password());
        userData.setU_password(md5);
        User user = iUserMapper.findUserByEmail(userData);
        if (user == null){
            result.setData(null);
            result.setStateCode(404);
            return result;
        }
        if (!user.getU_password().equals(userData.getU_password())){
            result.setStateCode(404);
            return result;
        }
        result.setStateCode(200);
        result.setData(user);
        return result;
    }

    @Override
    @Transactional
    public Result SaveUser(User user)  {
        Result result= new Result();
        if (user.getU_name()==null){
            String value = String.valueOf(System.currentTimeMillis());
            String substring = value.substring(value.length() - 6);
            user.setU_name("user"+substring);
            user.setGender("男");
        }
        String md5 = MD5.ToMD5(user.getU_password());
        user.setU_password(md5);
        int i= 0;
        try {
            i = iUserMapper.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i>=1){
            result.setStateCode(200);
        }else {
            result.setStateCode(404);
        }
        return result;
    }
}
