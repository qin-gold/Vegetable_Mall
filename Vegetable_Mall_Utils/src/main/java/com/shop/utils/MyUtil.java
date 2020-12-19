//package com.shop.utils;
//
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//
//import java.io.IOException;
//import java.io.InputStream;
///***
// * mybatis测试用
// * */
//public class MyUtil {
//    private static SqlSessionFactory sqlSessionFactory=null;
//    //初始化sqlsessionFactory对象
//    static {
//        try{
//            //读取配置文件
//            String resources= "Mybatis.xml";
//            InputStream inputStream= Resources.getResourceAsStream(resources);
//            sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public static SqlSession getSession(){
//        return sqlSessionFactory.openSession();
//    }
//}