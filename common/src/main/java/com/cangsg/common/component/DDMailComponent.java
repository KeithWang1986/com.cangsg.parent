package com.cangsg.common.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class DDMailComponent {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${spring.mail.from}")
	private String from;
	
	@Autowired
	private JavaMailSender mailSender;

	public void sendSimpleMail(String to, String subject, String content)  throws MailException {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		mailSender.send(message);
		logger.info("简单邮件已经发送。" + subject);
	}
}
