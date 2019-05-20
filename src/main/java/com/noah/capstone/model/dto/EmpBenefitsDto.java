package com.noah.capstone.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class EmpBenefitsDto {
	
	private int employeeId;
	private double totalWitholdings;
	private String errorMsg;
	
	public EmpBenefitsDto() {
		super();
	}

	public EmpBenefitsDto(int employeeId, double totalWitholdings) {
		super();
		this.employeeId = employeeId;
		this.totalWitholdings = totalWitholdings;
	}
	
	public EmpBenefitsDto(int employeeId, String errorMsg) {
		super();
		this.employeeId = employeeId;
		this.errorMsg = errorMsg;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public double getTotalWitholdings() {
		return totalWitholdings;
	}

	public void setTotalWitholdings(double totalWitholdings) {
		this.totalWitholdings = totalWitholdings;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "EmpBenefitsDto [employeeId=" + employeeId + ", totalWitholdings=" + totalWitholdings + ", errorMsg="
				+ errorMsg + "]";
	}	

}
