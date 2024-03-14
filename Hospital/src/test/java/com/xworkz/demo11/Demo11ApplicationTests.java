package com.xworkz.demo11;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.xworkz.demo11.controller.HospitalController;
import com.xworkz.demo11.dto.HospitalDTO;
import com.xworkz.demo11.repository.HospitalRepo;
import com.xworkz.demo11.service.HospitalService;

@SpringBootTest
//@DataJpaTest
@AutoConfigureMockMvc
class Demo11ApplicationTests {

	// private static final HospitalDTO HospitalDTO = null;
	// String name="bharat";

	@Autowired
	private MockMvc mockMvc;
	
	void inIt() {
		
	}
	
	@Autowired
	HospitalController controller;
	@Autowired
	HospitalService service;

	@Autowired
	HospitalRepo repo;

	
//	void toTest() throws Exception {
//		this.mockMvc		
//	}
	
	@Test
	void contextLoads() throws Exception {
		// assertEquals("bharat",name);
		// assertEquals("successfully patient detail Registered",
		// controller.registerDetails(dto));
		assertEquals(8, controller.add(3, 5));
//	assertThat(controller).isNotNull();
	}

	@Test
	void registerDetails() { //
		// ervice.registerPatient(dto);
		HospitalDTO dto = new HospitalDTO(1, "bharat", "male", 29, 7676767676l);
		HospitalDTO save = repo.save(dto);
		// assertEquals("successfully patient detail Registered",
		// controller.registerDetails(dto));
		assertNotNull(save);
	}

	@Test
	@Disabled
	void getDetailById() {
		int id = 1;
		HospitalDTO dto = controller.getDetailsById(id);
		assertThat(dto.getId()).isEqualTo(id);
	}
}
