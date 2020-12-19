package com.shop.utils;

/** 随机数类
 * @author qsj
 */
public class RandomUtil {
    public static String getRandom(){
        String code = String.valueOf(Math.random()*System.currentTimeMillis()).substring(3, 9);
        return code;
    }
}
