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
    private static String rootPath = null;
    private static String getRealPath =null;
    static {
        //读取配置文件
        InputStream resourceAsStream = JedisPoolUtils.class.getClassLoader().getResourceAsStream("upload.properties");
        //创建properties对象
        Properties properties=new Properties();
        //关联文件
        try{
            properties.load(resourceAsStream);
        }catch (Exception e){
            e.printStackTrace();
        }
        rootPath = properties.getProperty("upload.rootPath");
        getRealPath = properties.getProperty("upload.getRealPath");
    }
    public static String getUpload(MultipartFile file, HttpServletRequest request) {
        if(file.isEmpty()){
            System.out.println("文件未上传!");
        }else{
            //得到上传的文件名
            String fileName = file.getOriginalFilename();
            //得到服务器项目发布运行所在地址
            String path1 = request.getSession().getServletContext().getRealPath("images")+ File.separator;
            System.out.println(path1);
            //  此处未使用UUID来生成唯一标识,用日期做为标识
            String path2 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + fileName;
            String path=path1+path2;
            //打印文件上传路径，方便查看是否上传成功
            System.out.println(path);
            String rootPath = "D:/shop/images";
            File dir = new File(rootPath +File.separator+path2);
            System.out.println(dir.getName());
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
