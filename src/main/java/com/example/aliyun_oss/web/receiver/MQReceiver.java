package com.example.aliyun_oss.web.receiver;

import com.example.aliyun_oss.web.config.MQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MQReceiver {



		@RabbitListener(queues= MQConfig.QUEUE)
		public void receive2(String message) {
			log.info("receive message:"+message);
		}
}
