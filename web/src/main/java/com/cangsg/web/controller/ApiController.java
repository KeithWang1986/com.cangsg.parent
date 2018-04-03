package com.cangsg.web.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cangsg.web.bean.RoncooUserLog;
import com.cangsg.web.cache.RoncooUserLogCache;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private RoncooUserLogCache roncooUserLogCache;

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public HashMap<String, Object> get(@RequestParam String name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "hello world");
		map.put("name", name);
		return map;
	}

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public RoncooUserLog get(@RequestParam(defaultValue = "1") Integer id) {
		return roncooUserLogCache.selectById(id);
	}
}
