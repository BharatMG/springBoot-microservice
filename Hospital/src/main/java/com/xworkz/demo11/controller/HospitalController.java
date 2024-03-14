package com.xworkz.demo11.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.demo11.dto.HospitalDTO;
import com.xworkz.demo11.service.HospitalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/hospital")
@Tag(name = "HospitalController",description = "To perform operations on patient")
public class HospitalController {

//	HospitalDTO dto;

	HospitalService service;

	public HospitalController(HospitalService service) {
		this.service = service;
	}

	@Operation(summary = "Get operation on Patient Id",
			description = "It is get data from database"
			)
	@GetMapping("reg/{id}")
	public HospitalDTO getDetailsById(@PathVariable int id) {
		return service.getPatient(id);
		// new HospitalDTO(1, "bharat", "male", 29, 8553366463L);
	}

	@Operation(summary = "Get operation on Patient all Data",
			description = "It is get data from database"
			)
	@GetMapping
	public List<HospitalDTO> getAllDetails() {
		return service.getAllPatientDetail();
	}

	@Operation(summary = "Post operation on Patient all Data",
			description = "It is save data to database"
			)
	@PostMapping
	public String registerDetails(@RequestBody HospitalDTO dto) {
		// this.dto=dto;
		service.registerPatient(dto);
		return "successfully patient detail Registered";
	}
	
	
	@Operation(summary = "Put operation on Patient Data",
			description = "It is save data to database"
			)
	@PutMapping("update/{id}")
	public String putMethodName(@PathVariable String id, @RequestBody HospitalDTO dto) {
		service.updateRegisterPatient(dto);
		return "successfully patient update detail Registered";
	}
	
	
	@Operation(summary = "Delete operation on Patient all Data",
			description = "It is delete data to database"
			)
	@DeleteMapping("{id}")
	public String deleteDetails(@PathVariable Integer id) {
	//	this.dto = null;
		return "successfully patient detail deleted";
	}

	public int add(int a,int b) {
		return a+b;
	}

}
