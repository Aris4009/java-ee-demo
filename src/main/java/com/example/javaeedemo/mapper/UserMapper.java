package com.example.javaeedemo.mapper;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.javaeedemo.pojo.User;

@Component
public interface UserMapper extends BaseMapper<User> {
}
