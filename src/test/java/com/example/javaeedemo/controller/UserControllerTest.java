package com.example.javaeedemo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testList() throws Exception {
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/user/list"));
		resultActions
				.andExpectAll(MockMvcResultMatchers.status().isOk(), MockMvcResultMatchers.jsonPath("$.data").isArray())
				.andDo(MockMvcResultHandlers.print());
	}
}
