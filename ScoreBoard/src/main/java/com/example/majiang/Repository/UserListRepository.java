package com.example.majiang.Repository;

import com.example.majiang.Entity.UserList;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;


public interface UserListRepository extends MongoRepository<UserList,String> {
    ArrayList<UserList> findByNumber(int number);

}
