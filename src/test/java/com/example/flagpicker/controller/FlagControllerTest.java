/**
 * 
 */
package com.example.flagpicker.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author SRINIVASARAON
 *
 */
public class FlagControllerTest extends AbstractTest{
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void testByContinent() throws Exception {
		String uri = "/flags/bycontinent/Asia";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();

		//Country[] countries = (Country[]) super.mapFromJson(content, Country[].class);
		assertTrue((content.length()) > 0);
	}

	@Test
	public void testByCountry() throws Exception {
		String uri = "/flags/bycountry/India";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.IMAGE_JPEG))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();

		//Sales[] sales = (Sales[]) super.mapFromJson(content, Sales[].class);
		assertTrue((content.length()) > 0);
	}
}
