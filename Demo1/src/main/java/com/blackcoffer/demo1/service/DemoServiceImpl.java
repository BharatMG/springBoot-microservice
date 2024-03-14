package com.blackcoffer.demo1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blackcoffer.demo1.dto.DemoDTO;

@Service
public class DemoServiceImpl  {

	
	public List<DemoDTO> save(DemoDTO dto) {
		dto =new DemoDTO("bharat","bharatmg21@gmail.com", 8553366463L);
		
		return (List<DemoDTO>) dto;
	}

	
	
}
