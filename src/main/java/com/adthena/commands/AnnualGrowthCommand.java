package com.adthena.commands;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adthena.data.PopulationRepository;
import com.adthena.model.AnnualGrowth;

public class AnnualGrowthCommand implements Command {
	
	private Logger logger = LoggerFactory.getLogger(AnnualGrowthCommand.class);

	private PopulationRepository populationRepository;

	public AnnualGrowthCommand(PopulationRepository populationRepository) {
		this.populationRepository = populationRepository;
	}

	public void execute() {
		populationRepository.updateAnnualGrowth();
		
		List<AnnualGrowth> result = populationRepository.findTopAnnualGrowths(2);
		
		logger.info("Top two annual growth:");
		for (AnnualGrowth annualGrowth : result) {
			logger.info(String.format("%s: %s", annualGrowth.getRegion(), annualGrowth.getAnnualGrowth()));
		}
	}

}
