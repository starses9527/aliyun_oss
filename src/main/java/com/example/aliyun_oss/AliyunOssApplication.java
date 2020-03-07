package com.example.aliyun_oss;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
//@EnableScheduling     //如果是AsyncConfig配置 配合定时任务测试,则需要开启此注解
@EnableAsync    //开启线程池注解
@EnableRabbit   //开启rabbit注解


public class AliyunOssApplication {

  public static void main(String[] args) {
    SpringApplication.run(AliyunOssApplication.class, args);
  }

}
