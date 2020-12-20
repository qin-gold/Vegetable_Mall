package com.shop.utils;

import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @author qsj
 */
public class UploadUtil {
    public static String getUpload(MultipartFile file, HttpServletRequest request) {
        //读取配置文件
        InputStream resourceAsStream = UploadUtil.class.getClassLoader().getResourceAsStream("upload.properties");
        //创建properties对象
        Properties properties=new Properties();
        //关联文件
        try{
            properties.load(resourceAsStream);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                resourceAsStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String rootPath = properties.getProperty("upload.rootPath");
        String getRealPath = properties.getProperty("upload.getRealPath");
        if(file.isEmpty()){
        }else{
            String fileName = file.getOriginalFilename();
            String path1 = request.getSession().getServletContext().getRealPath(getRealPath)+ File.separator;
            System.out.println(path1);
            String path2 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + fileName;
            String path=path1+path2;
            File dir = new File(rootPath +File.separator+path2);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            try {
                file.transferTo(dir);
                return path2;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
