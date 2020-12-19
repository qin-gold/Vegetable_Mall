package com.shop.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 订单号生成工具(未处理高并发)
 * @author qsj
 */
public class OrdersUtil {
    public static synchronized String getOrderNo() {
        String str = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        str+=System.currentTimeMillis();
        return str;
    }
}
