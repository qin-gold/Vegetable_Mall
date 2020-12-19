package com.shop.service;

import com.shop.domain.User;
import com.shop.domain.Result;

import java.util.List;
/**
 *
 * @author qsj Cotter
 * @date 2020/10/7
 */
public interface UserService {

    /** 查询所有用户
     * @param pageNum
     * @param PageSize
     * @return
     * @throws Exception
     */
    List<User> findAllUser(int pageNum,int PageSize) throws Exception ;

    /** 保存用户的方法
     * @param user
     * @return
     * @throws Exception
     */
    Result saveUser(User user);

    /** 通过ID查询用户
     * @param u_id
     * @return
     * @throws Exception
     */
    User findUserById(int u_id) throws Exception;

    /** 通过用户名查询用户
     * @param u_name
     * @return
     * @throws Exception
     */
    User findUsername(String u_name) throws Exception;

    /** 通过邮箱查找用户
     * @param email
     * @return
     * @throws Exception
     */
    Result findEmail(String email) throws Exception;

    /** 更新用户密码
     * @param user
     * @return
     * @throws Exception
     */
    Result updateUserPassword(User user) throws Exception;

    /** 更新用户信息
     * @param user
     * @return
     * @throws Exception
     */
    Result updateUser(User user) throws Exception;

    /** 模糊查询用户
     * @param user
     * @param pageNum
     * @param PageSize
     * @return
     * @throws Exception
     */
    List<User> findLikeUser(User user, int pageNum, int PageSize)throws Exception;

    /** 通过手机查找用户
     * @param number
     * @return
     * @throws Exception
     */
    Result findUserByPhone(String number);
}
