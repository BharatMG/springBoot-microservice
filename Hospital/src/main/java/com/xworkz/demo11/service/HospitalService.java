package com.xworkz.demo11.service;

import java.util.List;

import com.xworkz.demo11.dto.HospitalDTO;

public interface HospitalService {

	public String registerPatient(HospitalDTO dto);
	public String updateRegisterPatient(HospitalDTO dto);
	public HospitalDTO getPatient(Integer id);
	public List<HospitalDTO> getAllPatientDetail();

}