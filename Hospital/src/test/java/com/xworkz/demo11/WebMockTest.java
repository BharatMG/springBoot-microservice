package com.xworkz.demo11;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.xworkz.demo11.controller.HospitalController;
import com.xworkz.demo11.dto.HospitalDTO;
import com.xworkz.demo11.repository.HospitalRepo;
import com.xworkz.demo11.service.HospitalService;
@SpringBootTest
@AutoConfigureMockMvc
public class WebMockTest {

	@Autowired
	HospitalController controller;

	@Autowired
	private MockMvc mockMvc;	
	
	@Autowired
	HospitalService service;
	@MockBean
	HospitalRepo repo;
	
	@Test
	void getPatientDetails() throws Exception{
		//when(service.getAllPatientDetail()).thenReturn(repo.findAll());
		//this.mockMvc.perform(get("/hospital")).andDo(print()).andExpect(status().isOk
	//			  ()) .andExpect(content().string(containsString("Hello, Mock")));
	//	*/
		/*
		 * mockMvc.perform(get("/hospital")). andExpect(status().isOk())
		 * .andExpect(content().string("successfully patient detail Registered"));
		 */
	
}
}