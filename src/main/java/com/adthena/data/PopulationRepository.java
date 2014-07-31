package com.adthena.data;

import static org.springframework.data.mongodb.core.mapreduce.MapReduceOptions.options;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.adthena.model.AnnualGrowth;
import com.adthena.model.AverageRateGrowthDeviation;

public class PopulationRepository {

	private static final String POPULATION_COLLECTION_NAME = "population";
	
	private static final String ANNUALGROWTH_COLLECTION_NAME = "annualGrowth";

	private static final String AVGRATEGROWTHDEVIATION_COLLECTION_NAME = "averageRateGrowthDeviation";

	private MongoOperations mongoOps;

	private Map<String, String> resources;

	public PopulationRepository(MongoOperations mongoOps, Map<String, String> resources) {
		this.mongoOps = mongoOps;
		this.resources = resources;
	}
	
	public void updateAnnualGrowth() {
		Query query = new Query().with(new Sort(Sort.Direction.ASC, "region")).with(new Sort(Sort.Direction.DESC, "year"));
		mongoOps.mapReduce(query, 
				POPULATION_COLLECTION_NAME, 
				resources.get("annualGrowth_map"),
				resources.get("annualGrowth_reduce"),
				options().outputCollection(ANNUALGROWTH_COLLECTION_NAME),
				AnnualGrowth.class);
	}
	
	public void updateAverangeRateGrowthDeviation() {
		mongoOps.mapReduce(POPULATION_COLLECTION_NAME,
				resources.get("averageRateGrowthDeviation_map"),
				resources.get("averageRateGrowthDeviation_reduce"), 
				options().outputCollection(AVGRATEGROWTHDEVIATION_COLLECTION_NAME),
				AverageRateGrowthDeviation.class);
	}
	
	public List<AverageRateGrowthDeviation> findTopAverangeRateGrowthDeviation(int limit) {
		return findTopResults(limit, "value", AverageRateGrowthDeviation.class);
	}
	
	public List<AnnualGrowth> findTopAnnualGrowths(int limit) {
		return findTopResults(limit, "value", AnnualGrowth.class);
	}
	
	private <T> List<T> findTopResults(int limit, String sortProperty, Class<T> clazz) {
		Query query = query(new Criteria()).limit(limit).with(new Sort(Sort.Direction.DESC, sortProperty));

		return mongoOps.find(query, clazz);
	}
	
}
