package com.xworkz.demo11.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.xworkz.demo11.dto.HospitalDTO;
//@AutoConfigureTestDatabase
//@DataJpaTest
@SpringBootTest
public class HospitalRepoTester {

	@Autowired
	private HospitalRepo repo;
	HospitalDTO dto;

	@BeforeEach
	void setUp() {
		dto = new HospitalDTO(8, "Karan", "male", 28, 9879879870l);
		repo.save(dto);
	}

	/*
	 * @AfterEach void tearDown() { dto = null; repo.deleteAll(); }
	 */
//Test case success
	@Test
	@DisplayName("check the save Data")
	void testFindName_found() {
		Optional<HospitalDTO> findTest = repo.findById(8);
		assertThat(findTest.get().getPatientName()).isEqualTo(dto.getPatientName());
		assertThat(findTest.get().getAge()).isEqualTo(dto.getAge());
	}
	
	//Test case Failure
	
	@Test
	void testFindName_Not_found() {
		Optional<HospitalDTO> findTest = repo.findById(9);
		assertThat(findTest.isEmpty()).isTrue();
	}
}
