package com.example.aliyun_oss;

import com.example.aliyun_oss.web.untity.ALiOssUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@EnableScheduling     //如果是AsyncConfig配置 配合定时任务测试,则需要开启此注解
@SpringBootTest
class AliyunOssApplicationTests {
  static {
  }
  @Test
  void contextLoads() throws Exception {

    List<File> files = new ArrayList<>();
    File file = new File("/Users/macos/Pictures", "night_room_girls_friends_things_computer_drinks_lamp_shelves_tv_87239_1680x1050.jpg");
    File file1 = new File("/Users/macos/Pictures", "vgpj95.jpg");
    File file2 = new File("/Users/macos/Pictures", "w891o6.jpg");
    File file3 = new File("/Users/macos/Pictures", "ymvq3k.jpg");
    File file4 = new File("/Users/macos/Pictures", "ymez5k.jpg");
    File file5 = new File("/Users/macos/Pictures", "yj6l6l.jpg");
    files.add(file);
    files.add(file5);
    files.add(file1);
    files.add(file2);
    files.add(file3);
    files.add(file4);
//    System.out.println(1);
    ALiOssUtils.uploadObject2OSSuplad(file1);

    for (int i = 0; i < files.size(); i++) {
      ALiOssUtils.uploadObject2OSSuplad(files.get(i));
      log.info(i + "--------------------第几次");
    }
  }

    @Test
    public void aVoid () {
//    OSS oss=ALiOssUtils.getOssclient();
      File file5 = new File("/Users/macos/Pictures", "yj6l6l.jpg");
      byte[] con = new byte[2];
      con[0] = 12;

//    int d=image2byte("/Users/macos/Pictures/"+"yj6l6l.jpg").length;
//    System.out.println(d);
//    oss.putObject("bettos", "yj6.jpg", new ByteArrayInputStream(con));
//    oss.shutdown();

    }
    //图片到byte数组
//  public byte[] image2byte(String path){
//    byte[] data = null;
//    FileImageInputStream input = null;
//    try {
//      input = new FileImageInputStream(new File(path));
//      ByteArrayOutputStream output = new ByteArrayOutputStream();
//      byte[] buf = new byte[1024];
//      int numBytesRead = 0;
//      while ((numBytesRead = input.read(buf)) != -1) {
//        output.write(buf, 0, numBytesRead);
//      }
//      data = output.toByteArray();
//      output.close();
//      input.close();
//    }
//    catch (FileNotFoundException ex1) {
//      ex1.printStackTrace();
//    }
//    catch (IOException ex1) {
//      ex1.printStackTrace();
//    }
//    return data;
//  }
//  @Autowired
//    RedisUtil redisUtil;
//  @Autowired
//  UserDao userDao;
  @Test
  public void dds(){
//      redisUtil.set("saas","dsasds");
      //    List<String> user=redisTemplate.lRange("user",0,-1);
//
//    System.out.println(user.size());
//    if(!redisTemplate.hasKey("user")){
//      List<User> list=new ArrayList<>();
//      list.add(userDao.queryUserByName("root"));
//      redisTemplate.lRightPushAll("user", String.valueOf(list));
//    }
//    System.out.println(JSON.toJSON(user));

//    System.out.println(redisTemplate.get("user"));
//    if (!redisTemplate.hasKey("sas")){
//      redisTemplate.set("sas","dasd");
//      System.out.println(1);
//    }
//    System.out.println(redisTemplate.get("sas"));
//    System.out.println(JSON.toJSON(userDao.queryUserByName("admin")));
    }

}
