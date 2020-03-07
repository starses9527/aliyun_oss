package com.example.aliyun_oss.web.dao;

import com.example.aliyun_oss.web.pojo.MessageBoard;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by li on 2019/3/27.
 */
public interface MessageBoardDao {

    void saveMessage(MessageBoard messageBoard);
  //@SelectProvider(type= MessageBoardDaoSql.class, method="select")
  List<MessageBoard> queryMessageList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    int queryMessageBoardTotal();
}
