package com.example.javaeedemo.config.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.example.javaeedemo.common.R;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class MyWebConfig extends WebMvcConfigurationSupport {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	private final MyErrorUtils myErrorUtils;

	public MyWebConfig(MyErrorUtils myErrorUtils) {
		this.myErrorUtils = myErrorUtils;
	}

	public static final String MY_ERROR_ATTRIBUTE = "myError";

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
		resolvers.add(new HandlerExceptionResolver() {
			@Override
			public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
					Object handler, Exception ex) {
				MyErrorUtils.MyError myError = myErrorUtils.myError(ex);
				R<Void> r;
				if (myError != null) {
					r = R.failed(myError.getCode(), myError.getMsg());
				} else {
					r = R.failed(500, ex.getMessage());
				}
				RequestAttributes requestAttributes = new ServletRequestAttributes(request, response);
				requestAttributes.setAttribute(MY_ERROR_ATTRIBUTE, r, RequestAttributes.SCOPE_REQUEST);
				RequestContextHolder.setRequestAttributes(requestAttributes);
				String s = null;
				try (PrintWriter printWriter = response.getWriter();) {
					s = objectMapper.writeValueAsString(r);
					response.setContentType(MediaType.APPLICATION_JSON_VALUE);
					response.sendError(500, s);
					printWriter.write(s);
					printWriter.flush();
				} catch (IOException e) {

				}
				return null;
			}
		});
	}
}
