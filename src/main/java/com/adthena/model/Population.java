package com.adthena.model;

public class Population {

	private int year;

	private String country;

	private String region;

	private int population;

	public Population(int year, String country, String region, int population) {
		this.year = year;
		this.country = country;
		this.region = region;
		this.population = population;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

}
