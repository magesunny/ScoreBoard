package com.example.majiang.Repository;

import com.example.majiang.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpRepository extends MongoRepository<User,String> {
}
