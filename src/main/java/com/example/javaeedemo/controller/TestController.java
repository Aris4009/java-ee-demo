package com.example.javaeedemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.javaeedemo.common.R;

@RestController
public class TestController {

	@RequestMapping("/test")
	public R<String> test() {
		return R.ok("Hello");
	}
}
