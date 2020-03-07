package com.example.aliyun_oss.web.dao;


import com.example.aliyun_oss.web.pojo.Tags;

import java.util.List;

/**
 * Created by li on 2019/3/16.
 */
public interface TagsDao {

    void saveTags(Tags tags);

    List<Tags> queryTagsList();

    int queryTagsTotal();
}
