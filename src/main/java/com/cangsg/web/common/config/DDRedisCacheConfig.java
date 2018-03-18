package com.cangsg.web.common.config;

import java.nio.charset.Charset;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

@Configuration
public class DDRedisCacheConfig extends CachingConfigurerSupport {
	private Charset charset = Charset.forName("UTF8");

	@Value("${spring.redis.ttl}")
	private long ttl;
	
	@Autowired
	public StringRedisTemplate stringRedisTemplate;

	@Bean
	public CacheManager cacheManager() {
		RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer())).serializeKeysWith(SerializationPair.fromSerializer(new StringRedisSerializer(charset))).entryTtl(Duration.ofSeconds(ttl));

		RedisCacheManager manager = new RedisCacheManager(new RedisCacheWriter() {

			@Override
			public void put(String name, byte[] key, byte[] value, Duration ttl) {
				ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
				ops.set(name + new String(key, charset), new String(value, charset), ttl.getSeconds(), TimeUnit.SECONDS);
			}

			@Override
			public byte[] get(String name, byte[] key) {
				ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
				String result = ops.get(name + new String(key, charset));
				if (result == null) {
					return null;
				}
				return result.getBytes(charset);
			}

			@Override
			public byte[] putIfAbsent(String name, byte[] key, byte[] value, Duration ttl) {
				ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
				ops.set(name + new String(key, charset), new String(value, charset), ttl.getSeconds(), TimeUnit.SECONDS);
				return value;
			}

			@Override
			public void remove(String name, byte[] key) {
				stringRedisTemplate.delete(name + new String(key, charset));
			}

			@Override
			public void clean(String name, byte[] pattern) {
				return;
			}

		}, configuration);
		return manager;
	}
}
