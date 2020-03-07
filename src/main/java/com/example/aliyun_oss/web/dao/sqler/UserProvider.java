package com.example.aliyun_oss.web.dao.sqler;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName: UserProvider
 * @Description: TODO
 * @author: lzj
 * @date: 2020/3/2  2:40 下午
 * 注意细节不能直接进行赋值要与#{xxx}方式或者拼接
 */
@Data
public class UserProvider {
//  public String queryUserByName(String userName) {
//    return new SQL() {
//      {
//
//        SELECT(Users.username.value);
//        FROM("user");
//        WHERE("username="+userName);
//      }
//    }.toString();
//    return "select  * from  user where username="+userName;
//  }

  @ToString
  public enum Users {
    username("username");
    private final String value;

    Users(String value) {
      this.value = value;
    }
    public String getValue(){
      return value;
    }

    // 构造器默认也只能是private, 从而保证构造函数只能在内部使用


  }
}
