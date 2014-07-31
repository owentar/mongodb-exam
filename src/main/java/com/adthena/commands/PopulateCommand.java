package com.adthena.commands;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;

import com.adthena.model.Population;

/**
 * Command that populates the database with initial data
 */
public class PopulateCommand implements Command {

	private final Logger logger = LoggerFactory.getLogger(PopulateCommand.class);

	private MongoOperations mongoOps;

	public PopulateCommand(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	public void execute() {
		List<Population> data = createData();

		mongoOps.dropCollection(Population.class);
		mongoOps.insertAll(data);

		logger.info("Database populated successfully");
	}

	private List<Population> createData() {
		List<Population> data = new ArrayList<Population>();
		data.add(new Population(2012, "England", "London", 49141671));
		data.add(new Population(2011, "England", "London", 49141671));
		data.add(new Population(2010, "England", "London", 49140041));
		data.add(new Population(2009, "England", "London", 49139431));
		data.add(new Population(2008, "England", "London", 49138831));

		data.add(new Population(2012, "Northern Ireland", "Belfast", 1685529));
		data.add(new Population(2011, "Northern Ireland", "Belfast", 1685427));
		data.add(new Population(2010, "Northern Ireland", "Belfast", 1685327));
		data.add(new Population(2009, "Northern Ireland", "Belfast", 1685287));
		data.add(new Population(2008, "Northern Ireland", "Belfast", 1685267));

		data.add(new Population(2012, "Scotland", "Edinburgh", 5062938));
		data.add(new Population(2011, "Scotland", "Edinburgh", 5062638));
		data.add(new Population(2010, "Scotland", "Edinburgh", 5062423));
		data.add(new Population(2009, "Scotland", "Edinburgh", 5062211));
		data.add(new Population(2008, "Scotland", "Edinburgh", 5062011));

		data.add(new Population(2012, "Wales", "Cardiff", 2903085));
		data.add(new Population(2011, "Wales", "Cardiff", 2903285));
		data.add(new Population(2010, "Wales", "Cardiff", 2903185));
		data.add(new Population(2009, "Wales", "Cardiff", 2903135));
		data.add(new Population(2008, "Wales", "Cardiff", 2903085));

		return data;
	}

}
