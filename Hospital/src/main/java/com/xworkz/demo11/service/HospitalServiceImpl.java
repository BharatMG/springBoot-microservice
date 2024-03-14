package com.xworkz.demo11.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xworkz.demo11.dto.HospitalDTO;
import com.xworkz.demo11.repository.HospitalRepo;

@Service
public class HospitalServiceImpl implements HospitalService {

	HospitalRepo repo;

	public HospitalServiceImpl(HospitalRepo repo) {
		this.repo = repo;
	}

	@Override
	public String registerPatient(HospitalDTO dto) {
		repo.save(dto);
		return "register success";
	}

	@Override
	public String updateRegisterPatient(HospitalDTO dto) {
		repo.save(dto);
		return "update successfully";
	}

	@Override
	public HospitalDTO getPatient(Integer id) {
		// TODO Auto-generated method stub
		return (HospitalDTO) repo.findById(id).get();
	}

	@Override
	public List<HospitalDTO> getAllPatientDetail() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
