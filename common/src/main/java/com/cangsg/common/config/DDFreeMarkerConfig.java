package com.cangsg.common.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import freemarker.template.Configuration;
import freemarker.template.TemplateModelException;

@Component
public class DDFreeMarkerConfig {
	@Value("${app.clientnumber}")
	private String clientnumber;

	@Autowired
	private Configuration configuration;

	@PostConstruct
	public void setVariables() throws TemplateModelException {
		configuration.setSharedVariable("clientnumber", clientnumber);
	}
}
