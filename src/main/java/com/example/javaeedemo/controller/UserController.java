package com.example.javaeedemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.javaeedemo.common.Ex;
import com.example.javaeedemo.common.R;
import com.example.javaeedemo.pojo.User;
import com.example.javaeedemo.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/list")
	public R<List<User>> list() {
		return R.ok(userService.list());
	}

	@PostMapping("/list/param")
	public R<List<User>> list(@RequestBody User user) {
		return R.ok(userService.list(user));
	}

	@GetMapping("/error")
	public R<Void> error() {
		throw new Ex("error");
	}
}
