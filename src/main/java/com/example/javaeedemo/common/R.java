package com.example.javaeedemo.common;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class R<T extends Serializable> implements Serializable {

	private static final long serialVersionUID = 4157353341429860093L;

	private T data;

	private String msg;

	private Integer code;

	public static <T extends Serializable> R<T> ok(T data) {
		HttpCode ok = HttpCode.OK;
		return R.<T>builder().data(data).code(ok.getCode()).msg(ok.getMsg()).build();
	}

	public static <T extends Serializable> R<T> failed(T data) {
		HttpCode failed = HttpCode.FAILED;
		return R.<T>builder().data(data).code(failed.getCode()).msg(failed.getMsg()).build();
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
