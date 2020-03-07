package com.example.aliyun_oss.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
/**
 * rabbitmq 配置
 */
public class MQConfig {


	public static final String QUEUE = "queue";


	/**
	 * Direct模式 交换机Exchange
	 * */
	@Bean
	public Queue queue() {
		log.info("------------------queue");

	  return new Queue(QUEUE, true);
	}
}
