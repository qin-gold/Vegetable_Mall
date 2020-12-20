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
            if (admin.getA_password()==null){
                result.setStateCode(404);
            }else {
                result.setStateCode(200);
                result.setData(admin);
            }
            return result;
        } catch (Exception e) {
            result.setStateCode(404);
            return result;
        }
    }
}
