package com.noah.capstone.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.noah.capstone.dao.model.WitholdingCurrency;
import com.noah.capstone.dao.repository.BenefitsRepository;
import com.noah.capstone.model.dto.EmpBenefitsDto;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeBenefitServiceTest {
	
	@Mock
	private BenefitsRepository repository;
	
	@Mock(name = "loadBalanced")
	private RestTemplate restTemplate;
	
	@Mock(name = "nonLoadBalanced")
	private RestTemplate nonLoadBalanced;
	
	@InjectMocks
	private final BenefitsService service = new BenefitsService();
	
	//TODO fix failing test
	@Test
	public void whenEmployeeFound_thenReturnBenefits() throws Exception {
		int employeeId = 11111;
		
		EmpBenefitsDto empBenefits = service.getBenefits(employeeId);
		assertNotNull(empBenefits);
		assertEquals(employeeId, empBenefits.getEmployeeId());
		assertEquals(125.0, empBenefits.getTotalWitholdings(), 0.0);
		assertEquals(WitholdingCurrency.USD, empBenefits.getCurrency());
	}

}
