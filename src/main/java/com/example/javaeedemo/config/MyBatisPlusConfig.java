package com.example.javaeedemo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;

@Configuration
@MapperScans(value = {@MapperScan("com.example.javaeedemo.mapper")})

public class MyBatisPlusConfig {

	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		return new MybatisCustomizeInterceptor();
	}
}
