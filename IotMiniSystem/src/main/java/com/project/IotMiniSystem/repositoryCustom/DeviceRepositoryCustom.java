package com.project.IotMiniSystem.repositoryCustom;



import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.client.model.Filters;
import com.project.IotMiniSystem.model.Device;

@Repository
public class DeviceRepositoryCustom {

	private static final String COLLECTION = "devices";
	 
	@Autowired
	MongoTemplate mongoTemplate;
	
	public long countDevices() {
		Query query = new Query();
		return mongoTemplate.count(query, COLLECTION);
	}
	
	public long countONDevices() {
		Query query = new Query();
		query.addCriteria(Criteria.where("state").is("ON"));
		return mongoTemplate.count(query, COLLECTION);
	}
	
	
	public List<Device> getRoomDevices(String roomId) {
		Query query = new Query(Criteria.where("location.$id").is(new ObjectId(roomId)));
		return mongoTemplate.find(query, Device.class, COLLECTION);
	}
	
	
	

	public Object totalPower() {
	   MatchOperation match = new MatchOperation(Criteria.where("state").is("ON"));
	   GroupOperation group = Aggregation.group().sum("max_value").as("count");
       Aggregation aggregate = Aggregation.newAggregation(match, group);
       AggregationResults<Device> orderAggregate = mongoTemplate.aggregate(aggregate,COLLECTION, Device.class);
        List<Document> doc = (List<Document>) orderAggregate.getRawResults().get("results");
        System.out.println("Output5 ====>" + orderAggregate.getRawResults());
	    System.out.println("Output10 ====>" + orderAggregate.getRawResults().get("results"));
	    if(doc.size() != 0) {
	       return doc.get(0).get("count") ; 
	    }else 
	       return 0;
	}
	
	
	
	
	

	
	
 
}
