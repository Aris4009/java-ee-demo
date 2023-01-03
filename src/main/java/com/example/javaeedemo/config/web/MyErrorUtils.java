package com.example.javaeedemo.config.web;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MyErrorUtils {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	private List<MyError> list = new ArrayList<>();

	private Resource resource;

	public MyErrorUtils(@Value("${my.error.path}") Resource resource) throws IOException {
		String s = Files.readString(resource.getFile().toPath());
		list = objectMapper.readValue(s, new TypeReference<>() {
		});
	}

	public MyError myError(Exception exception) {
		if (!(exception instanceof ServletException)) {
			return null;
		}

		for (MyError e : list) {
			if (exception.getClass().getName().equals(e.klass)) {
				return e;
			}
		}
		return null;
	}

	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class MyError implements Type {

		private String klass;

		private String msg;

		private int code;

		@Override
		public String getTypeName() {
			return klass;
		}
	}
}
