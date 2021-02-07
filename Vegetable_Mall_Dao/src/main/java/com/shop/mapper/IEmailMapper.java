package com.shop.mapper;

import com.shop.domain.EmailCheck;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author 84735
 */
//@Repository
public interface IEmailMapper {
    /** 查询Email是否存在
     * @param email
     * @return
     * @throws Exception
     */
    @Select("select user.email from user where email=#{email}")
    EmailCheck findEmail(String email) throws Exception;
}
