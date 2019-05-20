package com.noah.capstone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.noah.capstone.model.dto.EmpBenefitsDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"empstatus.eurekaURI = http://EMPSTATUS/empstatus/getstatus/{employeeId}", "empstatus.directURI=http://localhost:8098/empstatus/getstatus/{employeeId}"})
public class EmpBenefitsApplicationTests {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
		assertNotNull("Controller must be autowired", context);
	}
	
	@Test
	public void getBenefits() {
		ResponseEntity<EmpBenefitsDto> response = this.restTemplate.postForEntity("/empBenefits/getbenefits", getEmpIdAsJsonInput(11111), EmpBenefitsDto.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(11111, response.getBody().getEmployeeId());
	}
	
	private Map<String, String> getEmpIdAsJsonInput(int employeeId) {
		Map<String, String> empMap = new HashMap<>();
		empMap.put("employeeId", String.valueOf(employeeId));
		return empMap;
	}

}
