package com.shop.service;

import com.shop.domain.User;
import com.shop.domain.Result;
/**
 *
 * @author qsj Cotter
 * @date 2020/10/7
 */
public interface LoginService {
        /** 用户登录方法
         * @param userData
         * @return
         * @throws Exception
         */
          Result loginIn(User userData) throws Exception;

        /** 用户注册方法
         * @param user
         * @return
         * @throws Exception
         */
          Result SaveUser(User user) ;

}

