package com.example.javaeedemo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.javaeedemo.mapper.UserMapper;
import com.example.javaeedemo.pojo.User;

@Service
public class UserService {

	private UserMapper userMapper;

	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public List<User> list() {
		return userMapper.selectList(null);
	}

	public List<User> list(User user) {
		return userMapper.selectList(new QueryWrapper<>(user));
	}
}
