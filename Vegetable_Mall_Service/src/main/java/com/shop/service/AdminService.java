package com.shop.service;

import com.shop.domain.Admin;
import com.shop.domain.Result;

/**
 *
 * @author qsj Cotter
 * @date 2020/10/7
 */
public interface AdminService {

    /** 管理员登录方法
     * @param admin
     * @return
     */
    Result login(Admin admin);
}
