package com.noah.capstone.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noah.capstone.model.dto.EmpBenefitsDto;
import com.noah.capstone.service.BenefitsService;

@RestController
@RequestMapping(path = "/empBenefits")
public class EmployeeBenefitsController {
	
	Logger logger = LoggerFactory.getLogger(EmployeeBenefitsController.class);
	
	@Autowired
	BenefitsService service;
	
	@RequestMapping(path = "/info", produces = MediaType.TEXT_HTML_VALUE)
	private String info() {
		return "Employee Benefits service is up and running";
	}
	
	@PostMapping(path = "/getbenefits", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmpBenefitsDto getBenefits(@RequestBody Map<String, String> body) {
		String employeeId = body.get("employeeId");
		logger.debug("Getting benefits for employeeId " + employeeId);
		return service.getBenefits(Integer.parseInt(employeeId));
	}

}
