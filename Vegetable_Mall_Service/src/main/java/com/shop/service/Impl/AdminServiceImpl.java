package com.shop.service.Impl;

import com.shop.domain.Admin;
import com.shop.domain.Result;
import com.shop.mapper.IAdminMapper;
import com.shop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qsj
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private IAdminMapper iAdminMapper;
    @Override
    public Result login(Admin adminDate) {
        Result result=new Result();
        try {
            Admin admin = iAdminMapper.login(adminDate);
            if (!adminDate.getA_password().equals(admin.getA_password())){
                result.setMsg("密码错误");
                result.setStateCode(404);
                return result;
            }
            result.setData(admin);
            result.setStateCode(200);
            result.setMsg("登录成功");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("用户名不存在");
            result.setStateCode(404);
            return result;
        }
    }
}
