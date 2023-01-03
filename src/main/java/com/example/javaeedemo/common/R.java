package com.example.javaeedemo.common;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class R<T> {

	private T data;

	private String msg;

	private Integer code;

	public static <T> R<T> ok(T data) {
		HttpCode ok = HttpCode.OK;
		return R.<T>builder().data(data).code(ok.getCode()).msg(ok.getMsg()).build();
	}

	public static <T> R<T> failed() {
		HttpCode failed = HttpCode.FAILED;
		return R.<T>builder().code(failed.getCode()).msg(failed.getMsg()).build();
	}

	public static <T> R<T> failed(String... msg) {
		HttpCode failed = HttpCode.FAILED;
		return R.<T>builder().code(failed.getCode()).msg(Arrays.toString(msg)).build();
	}

	public static <T> R<T> failed(int code, String... msg) {
		return R.<T>builder().code(code).msg(Arrays.toString(msg)).build();
	}

	enum HttpCode {

		OK(200, "ok"), FAILED(500, "failed");

		private final int code;

		private final String msg;

		HttpCode(int code, String msg) {
			this.code = code;
			this.msg = msg;
		}

		public int getCode() {
			return code;
		}

		public String getMsg() {
			return msg;
		}
	}
}
