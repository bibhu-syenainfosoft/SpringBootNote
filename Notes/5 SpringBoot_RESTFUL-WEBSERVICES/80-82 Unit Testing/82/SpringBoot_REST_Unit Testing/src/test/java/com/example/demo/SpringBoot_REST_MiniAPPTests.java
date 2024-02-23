package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.nullable;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
public class SpringBoot_REST_MiniAPPTests {
	@Autowired
	private MockMvc mockMvc;

	//save Student
	@Test
	@Disabled
	public void testSave() throws Exception {
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.post("/rest/student/save").
				contentType(MediaType.APPLICATION_JSON).content("{\"prodId\":112,\"prodCode\":\"DEF\", \"prodCost\":10.0}");
		
		MvcResult result=mockMvc.perform(request).andReturn();
		
		MockHttpServletResponse response=result.getResponse();
		
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		
		if(!(response.getContentAsString().contains("Save"))) {
			fail();
		}	
	}
	
	
	//Fetch all Student
	@Test
	@Disabled
	public void testFetch() throws Exception {
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.get("/rest/student/all");
		
		MvcResult result=mockMvc.perform(request).andReturn();
		
		MockHttpServletResponse response=result.getResponse();
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals("application/json", response.getContentType());
		
		String resBody=response.getContentAsString();
		if(resBody==null || resBody.length()==0) {
			fail();
		}	
	}
	
	
	
	//Delete Student Data Based on Id
	@Test
	@Disabled
	public void testRemove() throws Exception {
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.delete("/rest/student/remove/112");
		
		MvcResult result=mockMvc.perform(request).andReturn();
		
		MockHttpServletResponse response=result.getResponse();
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		if(!(response.getContentAsString().contains("Deleted"))) {
			fail();
		}	
	}
	
	
	
	
	//pass success if Student is is not found to delete.
	@Test
	@Disabled
	public void testRemoveNotFound() throws Exception {
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.delete("/rest/student/remove/10");
		
		MvcResult result=mockMvc.perform(request).andReturn();
		
		MockHttpServletResponse response=result.getResponse();  //For this we have to add exception handler class inside exception package.
		   
		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
		
		if(!(response.getContentAsString().contains("Not Exist"))) {
			fail();
		}	
	}
	
	
	
	
	//update Student by id
	@Test
	@Disabled
	public void testUpdate() throws Exception {
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.put("/rest/student/update/112").
				contentType(MediaType.APPLICATION_JSON).content("{\"prodCode\":\"JKL\", \"prodCost\":99.0}");
		
		MvcResult result=mockMvc.perform(request).andReturn();
		
		MockHttpServletResponse response=result.getResponse();
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		if(!(response.getContentAsString().contains("Updated"))) {
			fail();
		}	
	}
	
	
	//pass success if Student is is not found to update.
	@Test
	@Disabled
	public void testUpdateNotFound() throws Exception {
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.put("/rest/student/update/10").
				contentType(MediaType.APPLICATION_JSON).content("{\"prodCode\":\"JKL\", \"prodCost\":99.0}");
		
		MvcResult result=mockMvc.perform(request).andReturn();
		
		MockHttpServletResponse response=result.getResponse();
		
		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
		
		if(!(response.getContentAsString().contains("Not Exist To Update"))) {
			fail();
		}	
	}
	
	
	
	//Fetch Student details based on Id
	@Test
	@Disabled
	public void testGetOneStudent() throws Exception {
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.get("/rest/student/getStudentById/112");
		
		MvcResult result=mockMvc.perform(request).andReturn();
		
		MockHttpServletResponse response=result.getResponse();
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals("application/json", response.getContentType());
		
		String resBody=response.getContentAsString();
		if(resBody==null || resBody.length()==0) {
			fail();
		}	
	}
	
	
	//pass success if id is not found
	@Test
	//@Disabled
	public void testGetOneStudentNotExist() throws Exception {
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.get("/rest/student/getStudentById/10");
		
		MvcResult result=mockMvc.perform(request).andReturn();
		
		MockHttpServletResponse response=result.getResponse();
		
		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());	
	}
}
