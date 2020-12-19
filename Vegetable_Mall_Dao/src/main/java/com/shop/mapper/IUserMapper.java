package com.shop.mapper;

import com.shop.domain.EmailCheck;
import com.shop.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author qsj Cotter
 * @date 2020/11/6
 */
@Repository
public interface IUserMapper {
    /** 根据用户名查询用户
     * @param username
     * @return
     * @throws Exception
     */
    @Select("select * from user where u_name=#{u_name} and state=0")
    User findByUsername(String username) throws Exception;

    /** 查询所有用户
     * @return
     * @throws Exception
     */
    @Select("select * from user")
    List<User> findAllUser() throws Exception;

    /** 插入一条用户数据
     * @param user
     * @return
     * @throws Exception
     */
    @Insert("insert into user(u_name,u_password,gender,phone,address,email) value(#{u_name},#{u_password},#{gender},#{phone},#{address},#{email})")
    int saveUser(User user) throws Exception;

    /** 根据id查询用户
     * @param u_id
     * @return
     * @throws Exception
     */
    @Select("select * from user where u_id=#{u_id} and state=0")
    User findUserById(Integer u_id) throws Exception;


    /** 更新用户信息
     * @param userData
     * @return
     * @throws Exception
     */
    @Update("update user set u_name=#{u_name},gender=#{gender},phone=#{phone},address=#{address} where email=#{email} or u_id=#{u_id}")
    Integer updateUser(User userData) throws Exception;

    /** 根据邮箱查找用户
     * @param email
     * @return
     * @throws Exception
     */
    @Select("select user.email from user where email=#{email} and state=0")
    EmailCheck findEmail(String email) throws Exception;

    /** 根据邮箱查找用户
     * @param user
     * @return
     * @throws Exception
     */
    @Select("select * from user where email=#{email} or phone=#{phone} and state=0")
    User findUserByEmail(User user) throws Exception;

    /** 根据手机查找用户
     * @param user
     * @return
     * @throws Exception
     */
    @Select("select * from user where phone=#{phone} and state=0")
    int findUserByPhone(String user) throws Exception;

    /** 更新用户密码
     * @param user
     * @return
     * @throws Exception
     */
    @Update("update user set u_password=#{u_password} where email=#{email} and state=0")
    int updatePassword(User user) throws Exception;

    /** 模糊查询用户
     * @return
     * @throws Exception
     * @param user
     */
    @Select("select * from user where u_name like concat('%',#{u_name},'%') or address like concat('%',#{address},'%') or email like concat('%',#{email},'%') ")
    List<User> findLikeProduct(User user) throws Exception;
}

