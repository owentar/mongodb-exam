package com.adthena.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class AnnualGrowth {

	@Id
	private String region;

//	private int currentPopulation;
//
//	private int oldPopulation;

	@Field("value")
	private float annualGrowth;

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

//	public int getCurrentPopulation() {
//		return currentPopulation;
//	}
//
//	public void setCurrentPopulation(int currentPopulation) {
//		this.currentPopulation = currentPopulation;
//	}
//
//	public int getOldPopulation() {
//		return oldPopulation;
//	}
//
//	public void setOldPopulation(int oldPopulation) {
//		this.oldPopulation = oldPopulation;
//	}

	public float getAnnualGrowth() {
		return annualGrowth;
	}

	public void setAnnualGrowth(float annualGrowth) {
		this.annualGrowth = annualGrowth;
	}

}
