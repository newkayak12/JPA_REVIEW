package com.board.board.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemberControllerTest {
	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	// @Before
	// public void setting(){
	// 	mvc = MockMvcBuilders.webAppContextSetup(context).build();
	// }
	@Test
	public void singinTest() throws Exception{
		String url = "/api/v1/signin/newkayak12/qwer1234";
		mvc.perform(get(url)).andExpect(status().isOk());
	}
}
