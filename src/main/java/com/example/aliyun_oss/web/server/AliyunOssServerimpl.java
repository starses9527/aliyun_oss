package com.example.aliyun_oss.web.server;

import com.example.aliyun_oss.web.config.MQConfig;
import com.example.aliyun_oss.web.untity.ALiOssUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;

/**
 * @ClassName: AliyunOssServer
 * @Description: TODO
 * @author: lzj
 * @date: 2020/2/28  2:03 下午
 */
@Slf4j
@Service
public class
AliyunOssServerimpl {
  @Autowired
  private RabbitTemplate rabbitTemplate;
  public String uplodes(String filepath){
    File file=new File(filepath);

//    rabbitTemplate.convertAndSend("images",ALiOssUtils.uploadObject2OSSuplad(file)+new Date());
      rabbitTemplate.convertAndSend(MQConfig.QUEUE,filepath);
      log.info(new Date()+"AliyunOssServerimpl----------------------uplodes()");
    return ALiOssUtils.uploadObject2OSSuplad(file)+new Date();
  }

}
