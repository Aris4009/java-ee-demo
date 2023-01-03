package com.example.javaeedemo.config.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.example.javaeedemo.common.R;

@RestController
public class ExController implements ErrorController {

	private final HttpServletRequest request;

	private final HttpServletResponse response;

	public ExController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	@RequestMapping("/error")
	public R<Void> handle() {
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		if (requestAttributes == null) {
			return R.failed(404, "请求路径错误");
		}
		R<Void> r = (R<Void>) requestAttributes.getAttribute(MyWebConfig.MY_ERROR_ATTRIBUTE,
				RequestAttributes.SCOPE_REQUEST);
		if (r == null) {
			return R.failed(404, "请求路径错误");
		}
		return r;
	}
}
