package com.fredy.projectbackend.Controllers;

import com.fredy.projectbackend.Models.User;
import com.fredy.projectbackend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserControllers {

    @Autowired
    UserRepository repositories;

    @RequestMapping(value = "/api/getUserName", produces = "application/json")
    public Object insertUser(Principal principal){
        User user = new User();
        //user.setName(principal.getName());

//        repositories.save(user);

        return user;
    }
}
