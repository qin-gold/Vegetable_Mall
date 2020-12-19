package com.shop.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5加密方法
 *
 * @author qsj*/
public class MD5 {
    public static synchronized String ToMD5(String str){
        return DigestUtils.md5Hex(str);
    }
}
