package com.fredy.projectbackend.Controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class UserControllers {



    @RequestMapping(value = "/api/getUserName", method = RequestMethod.GET )
    //@ResponseBody
    public ResponseEntity<String> getUserName(Principal principal){
        return ResponseEntity.ok(principal.getName());

    }

    @PostMapping(value="/api/logout")
    public ResponseEntity logout(){
        SecurityContextHolder.clearContext();
        return new ResponseEntity("logged out successfully", HttpStatus.OK);

    }
}
