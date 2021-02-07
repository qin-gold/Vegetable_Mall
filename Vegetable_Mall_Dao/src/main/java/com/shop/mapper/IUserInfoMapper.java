package com.shop.mapper;

import com.shop.domain.Admin;
import com.shop.domain.UserInfo;
import org.apache.ibatis.annotations.Select;

/**
 * @author qsj
 */
public interface IUserInfoMapper {

    /** 查询方法
     * @param ui
     * @return
     * @throws Exception
     */
    @Select("select * from userinfo where username=#{username}")
    UserInfo findUser(UserInfo ui) throws Exception;
}
