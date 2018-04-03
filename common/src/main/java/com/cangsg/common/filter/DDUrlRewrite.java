package com.cangsg.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(filterName = "UrlFilter", urlPatterns = "/s/*")
public class DDUrlRewrite implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(DDUrlRewrite.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("初始化Url版本重写");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.getRequestDispatcher(((HttpServletRequest) request).getRequestURI().substring(7)).forward(request, response);
	}

	@Override
	public void destroy() {
		logger.info("完成Url版本重写");
	}
}
