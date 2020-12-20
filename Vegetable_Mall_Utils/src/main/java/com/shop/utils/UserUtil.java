package com.shop.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 用户编号生成类
 * @author 84735
 */
public class UserUtil {
    public static synchronized String UserU_id(){
        String str = new SimpleDateFormat("yyMMdd").format(new Date());
        str+=String.valueOf(System.currentTimeMillis()).substring(5,13);
        return str;
    }
}
