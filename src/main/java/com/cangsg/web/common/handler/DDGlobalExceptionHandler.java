package com.cangsg.web.common.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.cangsg.web.common.exception.DDWebException;

@ControllerAdvice
public class DDGlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(DDGlobalExceptionHandler.class);

	@ExceptionHandler({ DDWebException.class })
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView handException(HttpServletRequest request, DDWebException e) throws Exception {
		return buildView("error/index", request, e);
	}

	@ExceptionHandler({ Exception.class })
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView handException(HttpServletRequest request, Exception e) throws Exception {
		return buildView("error/index", request, e);
	}

	private ModelAndView buildView(String viewPath, HttpServletRequest request, Exception e) {
		String message;
		if (e.getMessage() == null) {
			message = "";
		} else {
			message = e.getMessage();
		}
		logger.error(message);
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", message);
		mav.addObject("url", request.getRequestURL());
		mav.setViewName(viewPath);
		return mav;
	}
}
