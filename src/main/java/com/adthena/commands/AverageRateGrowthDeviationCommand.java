package com.adthena.commands;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adthena.data.PopulationRepository;
import com.adthena.model.AverageRateGrowthDeviation;

public class AverageRateGrowthDeviationCommand implements Command {
	
	private static final int DEFAULT_TOP_RESULTS = 2;
	
	private Logger logger = LoggerFactory.getLogger(AverageRateGrowthDeviationCommand.class);

	private PopulationRepository populationRepository;

	public AverageRateGrowthDeviationCommand(PopulationRepository populationRepository) {
		this.populationRepository = populationRepository;
	}

	public void execute() {
		populationRepository.updateAverangeRateGrowthDeviation();
		
		// TODO: support parameter on the execute method
		List<AverageRateGrowthDeviation> result = populationRepository.findTopAverangeRateGrowthDeviation(DEFAULT_TOP_RESULTS);

		logger.info("Top two deviations:");
		for (AverageRateGrowthDeviation averageDeviation : result) {
			logger.info(String.format("%s: %s", averageDeviation.getRegion(), averageDeviation.getDeviation()));
		}
	}

}
