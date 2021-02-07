package com.shop.mapper;

import com.shop.domain.Admin;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author qsj
 */
//@Repository
public interface IAdminMapper {
    /** 管理员登录的方法
     * @param admin
     * @return
     */
    @Select("select * from Admin where a_username=#{a_username} and a_password=#{a_password}")
    Admin login(Admin admin) throws Exception;
}
