package com.project.IotMiniSystem.repositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.project.IotMiniSystem.model.Device;

@Repository
public class LocationRepositoryCustom {

	private static final String COLLECTION = "locations";
	 
	@Autowired
	MongoTemplate mongoTemplate;
	
	public long totalRooms() {
		Query query = new Query();
		return mongoTemplate.count(query, COLLECTION);
	}
}
