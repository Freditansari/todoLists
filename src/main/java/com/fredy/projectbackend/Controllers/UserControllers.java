package com.fredy.projectbackend.Controllers;

import com.fredy.projectbackend.Models.User;
import com.fredy.projectbackend.Repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllers {

    @Autowired
    UserRepositories repositories;

    @RequestMapping(value = "/api/insertUser", produces = "application/json")
    public Object insertUser(){
        User user = new User();
        user.setName("Bob");

//        repositories.save(user);

        return user;
    }
}
