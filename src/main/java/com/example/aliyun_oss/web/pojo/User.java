package com.example.aliyun_oss.web.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by li on 2019/3/16.
 */
@Data
public class User implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String gender;
    private String email;
    private String avatarUrl;
    private String personalProfile;
    private Date createTime;
    private String lastLoginTime;
}
