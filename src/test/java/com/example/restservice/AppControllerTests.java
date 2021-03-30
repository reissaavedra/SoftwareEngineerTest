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

	@Test
	public void noParamGreetingShouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("Hello, World!"));
	}

	@Test
	public void paramGreetingShouldReturnTailoredMessage() throws Exception {
		this.mockMvc.perform(get("/greeting").param("name", "Spring Community"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("Hello, Spring Community!"));
	}

	@Test
	public void testES001() throws Exception {
		this.mockMvc.perform(post("/es001").param("param1", "123 abcd*3"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("123 bcde*3"));

		this.mockMvc.perform(post("/es001").param("param1", "**Casa 52"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("**Dbtb 52"));
	}

	@Test
	public void testES002() throws Exception {
		this.mockMvc.perform(post("/es002").param("values", "2,1,3,5"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("[1, 2, 3, 5]"));

		this.mockMvc.perform(post("/es002").param("values", "4,2,9"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("[2, 4, 9]"));

		this.mockMvc.perform(post("/es002").param("values", "58,60,55"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("[55, 58, 60]"));

		this.mockMvc.perform(post("/es002").param("values", "1,2,3"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("[1, 2, 3]"));
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

	@Test
	public void fill0() {
		ArrayList arr = new ArrayList();
		arr.add(2);
		arr.add(4);
		arr.add(1);
		arr.add(8);


		ArrayList testArray = new ArrayList();
		testArray.add(1);
		testArray.add(2);
		testArray.add(3);
		testArray.add(4);
		testArray.add(5);
		testArray.add(6);
		testArray.add(7);
		testArray.add(8);


//		ArrayList<Integer> arrayFilled0 = CompletedArray.fill0(arr, CompletedArray.getMayor(arr));
//		assertThat(arrayFilled0).isEqualTo(completedArray);

		ArrayList<Integer> arrayInputedValues = CompletedArray.solve(CompletedArray.fill0(arr, CompletedArray.getMayor(arr)));
		HeapSortedArray heapSortedArray = new HeapSortedArray(arrayInputedValues);
		assertThat(heapSortedArray.getArray()).isEqualTo(testArray);
	}
}
