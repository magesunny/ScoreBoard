package com.example.majiang.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document("exp")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Field
    private String name;

    @Field
    private int score;
}
