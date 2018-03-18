package com.cangsg.web.common.component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cangsg.web.common.DDTool;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class DDAnsiConverter extends ClassicConverter {

	private static final String END_COLOR = "\u001b[m";

	private static final String ERROR_COLOR = "\u001b[1;31m";
	private static final String WARN_COLOR = "\u001b[1;35m";
	private static final String INFO_COLOR = "\u001b[0;37m";
	private static final String GREEN_COLOR = "\u001b[1;32m";
	private static final String DEBUG_COLOR = "\u001b[1;32m";

	private String level_color = "";

	@Override
	public String convert(ILoggingEvent event) {
		StringBuffer sbuf = new StringBuffer();
		sbuf.append(getColor(event.getLevel()));
		sbuf.append("[" + DDTool.MSDateFormat(event.getTimeStamp()) + "] [");
		sbuf.append(localize(event.getLevel()));
		sbuf.append("] [");
		sbuf.append(event.getThreadName());
		sbuf.append("] ");
		sbuf.append(getMessage(event.getMessage()));
		sbuf.append(END_COLOR);
		sbuf.append("\r\n");
		return sbuf.toString();
	}

	private String getColor(Level level) {
		switch (level.toInt()) {
		case Level.ERROR_INT:
			this.level_color = ERROR_COLOR;
			break;
		case Level.WARN_INT:
			this.level_color = WARN_COLOR;
			break;
		case Level.INFO_INT:
			this.level_color = INFO_COLOR;
			break;
		case Level.DEBUG_INT:
			this.level_color = DEBUG_COLOR;
			break;
		default:
			return "";
		}
		return this.level_color;
	}

	private String localize(Level level) {
		switch (level.toInt()) {
		case Level.ERROR_INT:
			return "错误";
		case Level.WARN_INT:
			return "警告";
		case Level.INFO_INT:
			return "信息";
		case Level.DEBUG_INT:
			return "调试";
		default:
			return level.toString();
		}
	}

	private String getMessage(String message) {
		message = MatcherReplace(message, "\"\\{\\[", "\\}\"");
		return message;
	}

	private String MatcherReplace(String message, String start, String end) {
		Pattern part1 = Pattern.compile(start);
		Matcher m1 = part1.matcher(message);
		if (m1.find()) {
			Pattern part2 = Pattern.compile(end);
			message = m1.replaceAll(GREEN_COLOR + start);
			Matcher m2 = part2.matcher(message);
			message = m2.replaceAll(end + level_color);
		}
		return message;
	}
}