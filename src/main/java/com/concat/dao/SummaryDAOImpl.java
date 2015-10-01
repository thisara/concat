package com.concat.dao;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.concat.model.Counter;
import com.concat.model.Summary;

import static org.springframework.data.mongodb.core.query.Query.*;
import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.*;


@Repository
public class SummaryDAOImpl implements SummaryDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(SummaryDAOImpl.class);

	private MongoTemplate mongoTemplate;
	private final String SUMMARY_COLLECTION = "SUMMARY";
	private final String COUNTER_COLLECTION = "users";
	
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void addSummary(Summary s) {
		
		//Tempory solution, need to implement counter
		List<Summary> summaryList = listSummaries();
		Collections.sort(summaryList);
		Summary summary = summaryList.get(summaryList.size()-1);
		s.setId(summary.getId()+1);//getNextSequence(SUMMARY_COLLECTION));
		
		mongoTemplate.insert(s, SUMMARY_COLLECTION);
		logger.info("Summary saved successfully, Summary Details="+s);
	}

	@Override
	public void updateSummary(Summary s) {		
		mongoTemplate.save(s, SUMMARY_COLLECTION);
		logger.info("Summary updated successfully, Summary Details="+s);
	}

	@Override
	public List<Summary> listSummaries() {
		return this.mongoTemplate.findAll(Summary.class, SUMMARY_COLLECTION);
	}

	@Override
	public Summary getSummaryById(int id) {		
		Query query = new Query(Criteria.where("_id").is(id));
		return this.mongoTemplate.findOne(query, Summary.class, SUMMARY_COLLECTION);
	}

	@Override
	public void removeSummary(int id) {
		Query query = new Query(Criteria.where("_id").is(id));
		
		//WriteResult result = this.mongoTemplate.remove(query, Summary.class, SUMMARY_COLLECTION);
		//Session session = this.sessionFactory.getCurrentSession();
		//Summary p = (Summary) session.load(Summary.class, new Integer(id));
		//if(null != p){
		//	session.delete(p);
		//}
		//logger.info("Summary deleted successfully, Summary details="+p);
	}
	
	@Override
	public int getNextSequence(String collectionName) {
		
		Query query = new Query(Criteria.where("_id").is("1"));
		Counter counter = mongoTemplate.findOne(query, Counter.class, COUNTER_COLLECTION);
		
		int id = counter.getSeq();
		id = id + 1;
		   
	    return id;
	 }

}
