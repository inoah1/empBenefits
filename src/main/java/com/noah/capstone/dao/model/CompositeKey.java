package com.noah.capstone.dao.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompositeKey implements Serializable{
	
	private String benefitName;
	private int employeeId;	
	
	public CompositeKey() {
		super();
	}
	
	public CompositeKey(String benefitName, int employeeId) {
		super();
		this.employeeId = employeeId;
		this.benefitName = benefitName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getBenefitName() {
		return benefitName;
	}

	public void setBenefitName(String benefitName) {
		this.benefitName = benefitName;
	}

	@Override
	public String toString() {
		return "CompositeKey [employeeId=" + employeeId + ", benefitName=" + benefitName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((benefitName == null) ? 0 : benefitName.hashCode());
		result = prime * result + employeeId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeKey other = (CompositeKey) obj;
		if (benefitName == null) {
			if (other.benefitName != null)
				return false;
		} else if (!benefitName.equals(other.benefitName))
			return false;
		if (employeeId != other.employeeId)
			return false;
		return true;
	}	

}
