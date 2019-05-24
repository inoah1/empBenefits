package com.noah.capstone.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.noah.capstone.dao.model.BenefitsWitholdings;
import com.noah.capstone.dao.repository.BenefitsRepository;
import com.noah.capstone.model.dto.EmpBenefitsDto;
import com.noah.capstone.model.dto.EmpStatusDto;

@Service
public class BenefitsService {
	
	@Value("${empstatus.eurekaURI}")
	private String empStatusEurekaURI;
	
	@Value("${empstatus.directURI}")
	private String empStatusDirectURI;
	
	@Autowired
	@Qualifier("loadBalanced")
	RestTemplate restTemplate;
	
	@Autowired
	@Qualifier("nonLoadBalanced")
	RestTemplate restTemplateNonLoadBalanced;
	
	@Autowired
	BenefitsRepository repository;
	
	Logger logger = LoggerFactory.getLogger(BenefitsService.class);
	
	public EmpBenefitsDto getBenefits(int employeeId) {
		try {
			String empStatus = getStatus(employeeId).getEmpStatus();
			if("Active".equalsIgnoreCase(empStatus)) {
				List<BenefitsWitholdings> witholds = repository.findByIdEmployeeId(employeeId);
				double total = witholds.stream().map(BenefitsWitholdings::getWitholdingAmt).reduce(0.0, Double::sum);
				return new EmpBenefitsDto(employeeId, total,witholds.get(0).getWitholdingCurrency());
			} else {
				return new EmpBenefitsDto(employeeId, "NOT_FOUND");
			}
		} catch (Exception e) {
			logger.error("Exception in getBenefits", e);
			return new EmpBenefitsDto(employeeId, e.getMessage());
		}
	}
	
	@HystrixCommand(fallbackMethod = "getStatus_fallback")
	public EmpStatusDto getStatus(int employeeId) {
		logger.debug("Calling getEmployeeStatus from EUREKA URI");
		EmpStatusDto response = restTemplate.getForObject(empStatusEurekaURI, EmpStatusDto.class, employeeId);		
		return response;
	}
	
	public EmpStatusDto getStatus_fallback(int employeeId) {
		logger.debug("Calling getEmployeeStatus from DIRECT URI");
		EmpStatusDto response = restTemplateNonLoadBalanced.getForObject(empStatusDirectURI, EmpStatusDto.class, employeeId);		
		return response;
	}

}
