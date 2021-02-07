package com.shop.service.Impl;

import com.shop.domain.UserInfo;
import com.shop.mapper.IUserInfoMapper;
import com.shop.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Create by qsj computer
 *
 * @author qsj
 * @date 2021/2/7 11:05
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    private IUserInfoMapper infoMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userInfo = new UserInfo();
        UserInfo info = null;
        try {
             info = infoMapper.findUser(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = new User(info.getUsername(),info.getPassword(),null);
        return user;
    }
}
