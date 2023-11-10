package com.example.majiang.Controller;

import com.example.majiang.DBService;
import com.example.majiang.Entity.Total;
import com.example.majiang.Entity.User;
import com.example.majiang.Entity.UserList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@RestController
public class Controller {

    @Autowired
    private DBService dbService;

    @PostMapping(path = "/insert",consumes = "application/json")
    public void insert(@RequestBody User user){
        System.out.println(user);
        dbService.insert(user);
    }

    @GetMapping(path = "/getTotalByName")
    public List<Total> getTotalByName(){
        return dbService.getTotalByName();
    }

    @PostMapping(path = "/newUser")
    public void newUser(@RequestBody String newUser){
        log.info(newUser);
        dbService.newUser(newUser);
    }

    @GetMapping(path = "/userList")
    public ArrayList<UserList> userList(){
        return dbService.userList();
    }
}
