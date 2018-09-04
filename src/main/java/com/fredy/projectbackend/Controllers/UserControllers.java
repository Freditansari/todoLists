package com.fredy.projectbackend.Controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserControllers {



    @RequestMapping(value = "/api/getUserName", method = RequestMethod.GET )
    //@ResponseBody
    public ResponseEntity<String> getUserName(Principal principal){
        return ResponseEntity.ok(principal.getName());

    }
}
