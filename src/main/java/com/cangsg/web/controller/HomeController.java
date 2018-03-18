package com.cangsg.web.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cangsg.web.common.DDTool;

@Controller
@RequestMapping(value = "/")
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/")
	public String Index(Model model, HttpSession httpSession) {
		// map.put("title", "第二个应用：sessionID=" + httpSession.getId());
		logger.info("sessionID=" + httpSession.getId());
		String t = DDTool.MSDateFormat(1521100783617L);
		logger.info("time=" + t);
		logger.info("Hello red world!");
		logger.warn("Hello red world!");
		logger.error("Hello red world!");
		logger.debug("Hello red world!");
		return "index";
	}
}
