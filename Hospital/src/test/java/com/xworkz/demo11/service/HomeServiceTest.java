/**
 * 
 */
package com.xworkz.demo11.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.xworkz.demo11.dto.HospitalDTO;
import com.xworkz.demo11.repository.HospitalRepo;

import net.bytebuddy.asm.Advice.This;

public class HomeServiceTest {

	@Mock
	private HospitalRepo repo;
	HospitalService service;
	AutoCloseable autoCloseable;
	HospitalDTO dto;

	@BeforeEach
	void setUp() {
		autoCloseable = MockitoAnnotations.openMocks(this);
		service = new HospitalServiceImpl(repo);
		dto = new HospitalDTO(2, "bujji", "female", 5, 9090909090L);
	}

	@Test
	void testCreateHospitalPatient() {
		mock(HospitalDTO.class);
		mock(HospitalRepo.class);
		when(repo.save(dto)).thenReturn(dto);
		assertThat(service.registerPatient(dto)).isEqualTo("register success");
	}

	@Test
	void testUpdateHospitalPatient() {
		mock(HospitalDTO.class);
		mock(HospitalRepo.class);
		when(repo.save(dto)).thenReturn(dto);
		assertThat(service.updateRegisterPatient(dto)).isEqualTo("update successfully");
	}

	@Test
	@DisplayName("Check PatientId")
	void getDetailsById() {
		mock(HospitalDTO.class);
		mock(HospitalRepo.class);
		when(repo.findById(1)).thenReturn(Optional.ofNullable(dto));
		assertThat(service.getPatient(1).getPatientName()).isEqualTo(dto.getPatientName());
	}

	@Test
	void getAll() {
		mock(HospitalDTO.class);
		mock(HospitalRepo.class);
		when(repo.findAll()).thenReturn(new ArrayList<HospitalDTO>(Collections.singleton(dto)));
		assertThat(service.getAllPatientDetail().get(0).getMobileNumber())
		.isEqualTo(dto.getMobileNumber());

	}
}
