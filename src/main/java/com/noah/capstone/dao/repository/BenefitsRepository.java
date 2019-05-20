package com.noah.capstone.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.noah.capstone.dao.model.BenefitsWitholdings;
import com.noah.capstone.dao.model.CompositeKey;

@Repository
public interface BenefitsRepository extends CrudRepository<BenefitsWitholdings, CompositeKey>{
	
	List<BenefitsWitholdings> findByIdEmployeeId(int employeeId);

}
