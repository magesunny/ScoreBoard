package com.example.majiang;

import com.example.majiang.Entity.Total;
import com.example.majiang.Entity.User;
import com.example.majiang.Entity.UserList;
import com.example.majiang.Repository.UserListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DBService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private UserListRepository userListRepository;

    public void newUser(String name) {
        Query query = new Query(Criteria.where("number").is(1));
        Update update = new Update();
        update.push("userList", name);
        mongoTemplate.updateFirst(query, update, "userList");
    }

    public void insert(User user) {
        mongoTemplate.save(user);
    }

    public List<Total> getTotalByName() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("name")
                        .sum("score").as("totalScore")
                        .first("name").as("name"),
                Aggregation.sort(Sort.by(Sort.Order.desc("totalScore")))
        );
        AggregationResults<Total> results = mongoTemplate.aggregate(aggregation, "exp", Total.class);
        return results.getMappedResults();
    }

    public ArrayList<UserList> userList() {
        System.out.println(userListRepository.findByNumber(1));
        return userListRepository.findByNumber(1);
    }
}
