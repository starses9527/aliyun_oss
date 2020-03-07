package com.example.aliyun_oss.web.dao;


import com.example.aliyun_oss.web.pojo.Log;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author zhengli
 * @since 2019/03/07
 */

public interface LogDao {

    void saveLog(Log log);

    List<Log> queryLogList(@Param("key") String key, @Param("offset") Integer offset, @Param("limit") Integer limit);

    int queryLogTotal(@Param("key") String key);
}
