package com.xworkz.demo11.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.xworkz.demo11.dto.HospitalDTO;
import com.xworkz.demo11.service.HospitalService;

@WebMvcTest(HospitalController.class)
public class HospitalControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	HospitalService service;
	HospitalDTO dto1;
	HospitalDTO dto2;
	List<HospitalDTO> list = new ArrayList<>();

	@BeforeEach
	void setUp() {
		dto1 = new HospitalDTO(1, "mangesh", "Male", 11, 9090909090L);
		dto2 = new HospitalDTO(2, "ganesh", "Male", 22, 7790909090L);
		list.add(dto1);
		list.add(dto2);
	}

	@Test
	@Disabled
	void getById() throws Exception {
		when(service.getPatient(2)).thenReturn(dto1);
		this.mockMvc.perform(get("/hospital/reg/2")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	@Disabled
	void getAllDetails() throws Exception {
		when(service.getAllPatientDetail()).thenReturn(list);
		this.mockMvc.perform(get("/hospital")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	void CreatePatientDetailTest() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	com.fasterxml.jackson.databind.ObjectWriter	ow=mapper.writer().withDefaultPrettyPrinter();
		//ObjectWriter objectWriter = (ObjectWriter) objectMapper.writer().withDefaultPrettyPrinter();
		String reqJSON =  ow.writeValueAsString(dto1);

		when(service.registerPatient(dto1)).thenReturn("register success");
		this.mockMvc.perform(
				post("/hospital").contentType(org.springframework.http.MediaType.APPLICATION_JSON).content(reqJSON))
				.andDo(print()).andExpect(status().isOk());
	}

}
