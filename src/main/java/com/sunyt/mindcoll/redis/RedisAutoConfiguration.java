package com.sunyt.mindcoll.redis;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass()
@EnableConfigurationProperties()
public class RedisAutoConfiguration {
}
