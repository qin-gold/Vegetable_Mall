package com.shop.utils;

/** 邮箱验证类
 * @author qsj
 */
public class EmailCodeUtil {
    public static synchronized String getRandom(){
        String code = String.valueOf(System.currentTimeMillis()).substring(7, 13);
        return code;
    }
}
