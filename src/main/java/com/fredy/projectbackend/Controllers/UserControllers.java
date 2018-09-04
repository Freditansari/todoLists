package com.fredy.projectbackend.Controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserControllers {



    @RequestMapping(value = "/api/getUserName", method = RequestMethod.POST , produces = "application/json")
    public ResponseEntity<String> getUserName(Principal principal){



        return new ResponseEntity<String>( principal.getName(), HttpStatus.OK);

    }
}
