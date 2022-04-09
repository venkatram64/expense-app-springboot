package com.venkat.expense.repository;

import com.mongodb.client.result.DeleteResult;
import com.venkat.expense.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private MongoTemplate template;

    public User save(User user){
        return template.save(user);
    }

    public List<User> getAll(){
        return template.findAll(User.class);
    }

    public User update(User expense){
        return template.save(expense);
    }

    public long delete(String id){
        Query query = new Query(Criteria.where("_id").is(id));
        DeleteResult deleteResult = template.remove(query, "Users");
        return deleteResult.getDeletedCount();
    }

    public long delete(User user){
        return template.remove(user).getDeletedCount();
    }
}
