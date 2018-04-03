package com.cangsg.common.component;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DDAmqpComponent {
	@Value("${server.port}")
	private String port;

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void send(String msg) {
		this.amqpTemplate.convertAndSend("roncoo.queue", msg);
	}

	@RabbitListener(queues = "roncoo.queue")
	public void receiveQueue(String text) throws Exception {
		System.out.println("Receiver 1：" + text);
	}
	
	@RabbitListener(queues = "roncoo.queue")
	public void receiveQueue2(String text) throws Exception {
		System.out.println("Receiver 2：" + text);
	}
	
	@RabbitListener(queues = "roncoo.queue")
	public void receiveQueue3(String text) throws Exception {
		System.out.println("Receiver 3：" + text);
	}
}