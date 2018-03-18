package com.cangsg.web.common.database;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

/**
 * spirng jdbc 基本支撑类
 * 
 */
public abstract class DDJdbcDaoImpl {

	/**
	 * 获取当前事务最后一次更新的主键值
	 */
	public Long getLastId(JdbcTemplate jdbcTemplate) {
		return jdbcTemplate.queryForObject("select last_insert_id() as id", Long.class);
	}

	/**
	 * 获取对象信息
	 */
	public <T> T queryForObject(JdbcTemplate jdbcTemplate, String sql, Class<T> clazz, Object... args) {
		Assert.hasText(sql, "sql 语句不能为空");
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<T>(clazz), args);
	}

	/**
	 * 获取对象集合信息
	 */
	public <T> List<T> queryForObjectList(JdbcTemplate jdbcTemplate, String sql, Class<T> clazz, Object... args) {
		Assert.hasText(sql, "sql 语句不能为空");
		return jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<T>(clazz));
	}

	/**
	 * 分页，jdbcTemplate 不支持like
	 */
	public DDPage<Map<String, Object>> queryForPage(JdbcTemplate jdbcTemplate, String sql, int pageCurrent, int pageSize, Object... args) {
		Assert.hasText(sql, "sql 语句不能为空");
		Assert.isTrue(pageCurrent >= 1, "pageNo 必须大于等于1");
		String sqlCount = DDSql.countSql(sql);
		int count = jdbcTemplate.queryForObject(sqlCount, Integer.class, args);
		pageCurrent = DDSql.checkPageCurrent(count, pageSize, pageCurrent);
		pageSize = DDSql.checkPageSize(pageSize);
		int totalPage = DDSql.countTotalPage(count, pageSize);
		String sqlList = sql + DDSql.limitSql(count, pageCurrent, pageSize);
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sqlList, args);
		return new DDPage<Map<String, Object>>(count, totalPage, pageCurrent, pageSize, list);
	}

	/**
	 * 分页，jdbcTemplate 不支持like
	 */
	public <T> DDPage<T> queryForPage(JdbcTemplate jdbcTemplate, String sql, int pageCurrent, int pageSize, Class<T> clazz, Object... args) {
		Assert.hasText(sql, "sql 语句不能为空");
		Assert.isTrue(pageCurrent >= 1, "pageNo 必须大于等于1");
		Assert.isTrue(clazz != null, "clazz 不能为空");
		String sqlCount = DDSql.countSql(sql);
		int count = jdbcTemplate.queryForObject(sqlCount, Integer.class, args);
		pageCurrent = DDSql.checkPageCurrent(count, pageSize, pageCurrent);
		pageSize = DDSql.checkPageSize(pageSize);
		int totalPage = DDSql.countTotalPage(count, pageSize);
		String sqlList = sql + DDSql.limitSql(count, pageCurrent, pageSize);
		List<T> list = jdbcTemplate.query(sqlList, new BeanPropertyRowMapper<T>(clazz), args);
		return new DDPage<T>(count, totalPage, pageCurrent, pageSize, list);
	}
}
