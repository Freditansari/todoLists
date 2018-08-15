package com.fredy.projectbackend.Controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserControllers {



    @RequestMapping(value = "/api/getUserName", method = RequestMethod.POST , produces = "application/json")
    public String getUserName(Principal principal){


        return principal.getName();
    }
}
