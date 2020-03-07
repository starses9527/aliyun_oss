package com.example.aliyun_oss.web.contorller;

import com.alibaba.fastjson.JSON;
import com.example.aliyun_oss.web.server.AliyunOssServerimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;


@Controller
@RequestMapping("/demo")
public class SampleController {
//@Resource
//  ALiOssUtils aLiOssUtils;
//@Resource
//  RedisUtil redisUtil;
  @Autowired
  AliyunOssServerimpl aliyunOssServerimpl;

  @RequestMapping("/mq")
  @ResponseBody
  public Object mq(Array str) {
    System.out.println(JSON.toJSON(str));
    //    aliyunOssServerimpl.uplodes(file1.toString());
return "";
  }
  @RequestMapping("qqq")
  public String deos(){
//    redisUtil.set("sds","sdaads");
//    return redisUtil.get("sds");
  return "";
  }
}
