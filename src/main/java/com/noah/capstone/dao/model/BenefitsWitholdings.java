package com.noah.capstone.dao.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class BenefitsWitholdings {
	
	@EmbeddedId
	private CompositeKey id;
	private double witholdingAmt;
	@Enumerated(EnumType.STRING)
	private WitholdingCurrency witholdingCurrency;
	
	public BenefitsWitholdings() {
		super();
	}

	public BenefitsWitholdings(CompositeKey id, double witholdingAmt) {
		super();
		this.id = id;
		this.witholdingAmt = witholdingAmt;
	}

	public CompositeKey getId() {
		return id;
	}

	public void setId(CompositeKey id) {
		this.id = id;
	}

	public double getWitholdingAmt() {
		return witholdingAmt;
	}

	public void setWitholdingAmt(double witholdingAmt) {
		this.witholdingAmt = witholdingAmt;
	}

	public WitholdingCurrency getWitholdingCurrency() {
		return witholdingCurrency;
	}

	public void setWitholdingCurrency(WitholdingCurrency witholdingCurrency) {
		this.witholdingCurrency = witholdingCurrency;
	}

	@Override
	public String toString() {
		return "BenefitsWitholdings [id=" + id + ", witholdingAmt=" + witholdingAmt + "]";
	}

}
