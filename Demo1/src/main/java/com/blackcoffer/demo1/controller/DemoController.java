package com.blackcoffer.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.blackcoffer.demo1.dto.DemoDTO;
import com.blackcoffer.demo1.service.DemoServiceImpl;

@RestController
public class DemoController {

	@Autowired
	DemoServiceImpl service;
	
	@GetMapping("/save")
	public String saveData(@ModelAttribute DemoDTO dto) {
		System.out.println("welcome to demo");
		//List<DemoDTO> dto1 =service.save(dto);
		//System.err.println(dto1);
		return "dto";
	}
}
