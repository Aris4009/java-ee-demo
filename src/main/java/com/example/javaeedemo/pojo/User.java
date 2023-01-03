package com.example.javaeedemo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("test.user")
public class User {
	private Long id;
	private String name;
	private Integer age;
	private String email;
}
