package com.shop.utils;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.io.*;
import java.util.Properties;

/** 一个邮箱工具类
 * @author qsj
 *
 */
public class EmailUtil {
    public String EmailPort(String UserEmail)  {
        String code = RandomUtil.getRandom();
        Properties properties=new Properties();
        try {
            // 通过输入缓冲流进行读取配置文件
            InputStream resourceAsStream = EmailUtil.class.getClassLoader().getResourceAsStream("email.properties");
            // 加载输入流
            properties.load(resourceAsStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //创建一个htmlEmail实例
        HtmlEmail email=new HtmlEmail();
        //邮箱的SMTP服务器，一般123邮箱的是smtp.123.com,qq邮箱为smtp.qq.com
        email.setHostName(properties.getProperty("email.HostName"));
        //设置发送的字符类型
        email.setCharset(properties.getProperty("email.Charset"));
        try {
            email.addTo(UserEmail);
            //发送人的邮箱为自己的，用户名可以随便填
            email.setFrom(properties.getProperty("email.From.email"),properties.getProperty("email.From.name"));
            email.setAuthentication(properties.getProperty("email.Authentication.username"),properties.getProperty("email.Authentication.password"));
            //设置发送主题
            email.setSubject("蔬果商城邮箱验证码");
            String msg="验证码是:"+code+" 打死也不要将该验证码告诉别人哦";
            //设置发送内容
            email.setMsg(msg);
            //进行发送
            email.send();
            return code;
        } catch (EmailException e) {
            e.printStackTrace();
        }
        return code;
    }
}
