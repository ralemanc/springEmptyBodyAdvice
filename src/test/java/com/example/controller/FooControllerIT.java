package com.example.controller;

import com.example.configuration.WebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Foo Controller Test
 *
 * @author rafa aleman
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
public class FooControllerIT {

	public static final String VERSION_HEADER = "version";

	public static final String VERSION_VALUE = "1";
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testGetReturnString() throws Exception {
		final MvcResult result = this.mockMvc.perform(put("/foo")).andExpect(status().isOk()).andReturn();
		assertNotNull(result.getResponse().getHeader(VERSION_HEADER));
		assertEquals(result.getResponse().getHeader(VERSION_HEADER), VERSION_VALUE);
	}

	@Test
	public void testEmptyBody() throws Exception {
		final MvcResult result = this.mockMvc.perform(put("/foo/empty")).andExpect(status().isOk()).andReturn();
		assertNotNull(result.getResponse().getHeader(VERSION_HEADER));
		assertEquals(result.getResponse().getHeader(VERSION_HEADER), VERSION_VALUE);
	}
}
