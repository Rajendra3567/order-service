package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.data.mongodb.core.FindAndModifyOptions;

import com.order.entity.Sequence;

@Service
public class SequenceGenerator {

	@Autowired
	private MongoOperations mongoOperations;

	public SequenceGenerator(MongoOperations mongoOperations) {
		super();
		this.mongoOperations = mongoOperations;
	}

	public int generateNextOrderId() {

		Sequence counter = mongoOperations.findAndModify(query(where("_id").is("sequence")),
				new Update().inc("sequence", 1), new FindAndModifyOptions().returnNew(true).upsert(true),
				Sequence.class);

		return counter != null ? counter.getSequence() : 1; // Handle potential null return
	}
}
