package com.example.javaeedemo.controller.autowire;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.javaeedemo.common.R;
import com.example.javaeedemo.services.autowire.AutowireService;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/autowire")
@Slf4j
public class AutowireController {

	private AutowireService autowireService;

	@Autowired
	public void prepare(AutowireService autowireService) {
		this.autowireService = autowireService;
		log.info("inject");
	}

	@Data
	@Builder
	static class Result implements Serializable {

		private static final long serialVersionUID = 6261294874505662803L;

		private String name;

		private Integer age;
	}

	@GetMapping("/test")
	public R<Result> test() {
		Result result = Result.builder().age(18).name("Tom").build();
		log.info(autowireService.hello());
		return R.ok(result);
	}
}
