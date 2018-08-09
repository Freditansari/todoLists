package com.fredy.projectbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
*todo:
* ~~1. insert json to database directly[done]~~
* 2. take websecurity to database
* 3. take authserverconfig to database(optional)
* 4. file uploads
*
 */
@SpringBootApplication
public class ProjectbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectbackendApplication.class, args);
    }
}
