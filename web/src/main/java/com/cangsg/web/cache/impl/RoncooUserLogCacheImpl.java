package com.cangsg.web.cache.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.cangsg.web.bean.RoncooUserLog;
import com.cangsg.web.cache.RoncooUserLogCache;
import com.cangsg.web.dao.impl.RoncooUserLogDao;

/**
 * @author wujing
 */
@CacheConfig(cacheNames = "roncooCache")
@Repository
public class RoncooUserLogCacheImpl implements RoncooUserLogCache {

	@Autowired
	private RoncooUserLogDao roncooUserLogDao;

	@Cacheable(key = "#p0")
	@Override
	public RoncooUserLog selectById(Integer id) {
		System.out.println("查询功能，缓存找不到，直接读库, id=" + id);
		RoncooUserLog r=roncooUserLogDao.findByUserName("王刚").get(0);
		r.setCreateTime(new Date());
		return r;
	}

	@CachePut(key = "#p0.id")
	@Override
	public RoncooUserLog updateById(RoncooUserLog roncooUserLog) {
		System.out.println("更新功能，更新缓存，直接写库, id=" + roncooUserLog);
		return roncooUserLogDao.save(roncooUserLog);
	}

	@CacheEvict(key = "#p0")
	@Override
	public String deleteById(Integer id) {
		System.out.println("删除功能，删除缓存，直接写库, id=" + id);
		return "清空缓存成功";
	}

	@Override
	public RoncooUserLog selectById2(Integer id) {
		// TODO Auto-generated method stub
		return null;
	} 
}
