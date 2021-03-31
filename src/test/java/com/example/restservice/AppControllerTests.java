/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.restservice;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

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

//	@Test
//	public void testES003() throws Exception {
//		this.mockMvc.perform(post("/es003").param("value", "1"))
//				.andDo(print()).andExpect(status().isOk())
//				.andExpect(jsonPath("$.content").value("1.0"));
//
//		this.mockMvc.perform(post("/es003").param("value", "10.50"))
//				.andDo(print()).andExpect(status().isOk())
//				.andExpect(jsonPath("$.content").value("10.5"));
//	}
}
