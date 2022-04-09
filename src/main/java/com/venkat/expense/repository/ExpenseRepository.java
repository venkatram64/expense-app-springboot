package com.venkat.expense.repository;

import com.mongodb.client.result.DeleteResult;
import com.venkat.expense.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExpenseRepository {

    @Autowired
    private MongoTemplate template;

    public Expense save(Expense expense){
        return template.save(expense);
    }

    public List<Expense> getAll(){
        return template.findAll(Expense.class);
    }

    public Expense update(Expense expense){
        return template.save(expense);
    }

    public long delete(String id){
        Query query = new Query(Criteria.where("_id").is(id));
        DeleteResult deleteResult = template.remove(query, "expenses");
        return deleteResult.getDeletedCount();
    }

    public long delete(Expense expense){
        return template.remove(expense).getDeletedCount();
    }
}
