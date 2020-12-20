package com.shop.service.Impl;

import com.github.pagehelper.PageHelper;
import com.shop.domain.User;
import com.shop.mapper.IUserMapper;
import com.shop.service.UserService;
import com.shop.domain.EmailCheck;
import com.shop.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author qsj
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserMapper iUserMapper;
    @Override
    public List<User> findAllUser(int pageNum, int PageSize) throws Exception {
        PageHelper.startPage(pageNum,PageSize);
        return iUserMapper.findAllUser();
    }

    @Override
    public Result saveUser(User user) {
        Result result=new Result();
        if (user.getU_name()==null){
            String value = String.valueOf(System.currentTimeMillis());
            String substring = value.substring(value.length() - 6);
            user.setU_name("user"+substring);
            user.setGender("男");
        }
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

    @Override
    public User findUserById(String u_id) throws Exception {
        return iUserMapper.findUserById(u_id);
    }

    @Override
    public User findUsername(String u_name) throws Exception {
        return iUserMapper.findByUsername(u_name);
    }

    @Override
    public Result findEmail(String email) throws Exception {
        Result result = new Result();
        EmailCheck check = iUserMapper.findEmail(email);
        if (check==null){
            result.setStateCode(404);
            return result;
        }
        result.setStateCode(200);
        result.setData(check.getEmail());
        return result;
    }

    @Override
    public Result updateUser(User user) throws Exception {
        Result result=new Result();
        Integer integer = iUserMapper.updateUser(user);
        if (integer>=1){
            result.setStateCode(200);
            return result;
        }
        result.setStateCode(404);
        return result;
    }

    @Override
    public List<User> findLikeUser(User user, int pageNum, int PageSize) throws Exception {
        PageHelper.startPage(pageNum,PageSize);
        return iUserMapper.findLikeProduct(user);
    }

    @Override
    public Result findUserByPhone(String number) {
        Result result=new Result();
        int i=0;
        try {
            i = iUserMapper.findUserByPhone(number);
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

    @Override
    public Result updateUser0(String u_id) {
        Result result=new Result();
        try {
            int i = iUserMapper.updateUser0(u_id);
            if (i>=1){
                result.setStateCode(200);
            }else {
                result.setStateCode(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result updateUser1(String u_id) {
        Result result=new Result();
        try {
            int i = iUserMapper.updateUser1(u_id);
            if (i>=1){
                result.setStateCode(200);
            }else {
                result.setStateCode(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional
    public Result updateUserPassword(User user) throws Exception {
        Result result = new Result();
        int code = iUserMapper.updatePassword(user);
        if (code>=1){
            result.setStateCode(200);
        }else {
            result.setStateCode(400);
        }
        return result;
    }

}
