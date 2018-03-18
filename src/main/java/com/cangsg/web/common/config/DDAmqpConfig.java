package com.cangsg.web.common.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DDAmqpConfig {
	@Bean
	public Queue queue() {
		return new Queue("roncoo.queue");
	}
}
