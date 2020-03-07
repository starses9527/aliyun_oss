package com.example.aliyun_oss.web.pojo.component;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lightClouds917
 * Date 2018/1/16
 * Description:配置文件配置项
 */
@Component
public class ConstantProperties implements InitializingBean {

    @Value("${media.endpoint}")
    private String media_endpoint;

    @Value("${media.keyid}")
    private String media_keyid;

    @Value("${media.keysecret}")
    private String media_keysecret;

    @Value("${media.filehost}")
    private String media_filehost;

    @Value("${media.bucketname1}")
    private String media_bucketname1;


    public static String POINT;
    public static String KEY_ID;
    public static String KEY_SECRET;
    public static String BUCKET_NAME1;
    public static String HOST;

    @Override
    public void afterPropertiesSet() throws Exception {
        POINT = media_endpoint;
        KEY_ID = media_keyid;
        KEY_SECRET = media_keysecret;
        HOST = media_filehost;
        BUCKET_NAME1 = media_bucketname1;
    }
}
