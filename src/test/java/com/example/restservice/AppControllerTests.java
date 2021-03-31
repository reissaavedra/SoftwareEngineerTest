package com.example.restservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class AppControllerTests {

	@Autowired
	private MockMvc mockMvc;

	private void makeTest(String test, String param, String actualValues, String expectedValues) throws Exception {
		this.mockMvc.perform(post(test).param(param, actualValues))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value(expectedValues));
	}

	@Test
	public void testES001() throws Exception {
		String path = "/es001";
		String param = "param1";
		makeTest(path, param, "123 abcd*3", "123 bcde*3");
		makeTest(path, param, "**Casa 52", "**Dbtb 52");
	}

	@Test
	public void testES002() throws Exception {
		String path = "/es002";
		String param = "values";
		makeTest(path, param, "2,1,4,5", "[1, 2, 3, 4, 5]");
		makeTest(path, param, "2,4,1,8", "[1, 2, 3, 4, 5, 6, 7, 8]");
		makeTest(path, param, "4,2,9", "[1, 2, 3, 4, 5, 6, 7, 8, 9]");
	}
}
