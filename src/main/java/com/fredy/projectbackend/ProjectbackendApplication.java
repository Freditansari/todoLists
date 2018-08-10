package com.fredy.projectbackend;

import com.fredy.projectbackend.Models.Role;
import com.fredy.projectbackend.Models.User;
import com.fredy.projectbackend.Models.UserRole;
import com.fredy.projectbackend.Repositories.UserRepository;
import com.fredy.projectbackend.Security.SecurityUtility;
import com.fredy.projectbackend.Security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

/*
*todo:
* ~~1. insert json to database directly[done]~~
* 2. take websecurity to database
* 3. take authserverconfig to database(optional)
* 4. file uploads
*
 */
@SpringBootApplication
public class ProjectbackendApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(ProjectbackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        User user1 = new User();
//		user1.setName("John");
//		user1.setLastName("Adams");
//		user1.setUsername("jadams");
//		user1.setPassword(passwordEncoder.encode("johnadams123"));
//		user1.setEmail("JAdams@gmail.com");
//		Set<UserRole> userRoles = new HashSet<>();
//		Role role1 = new Role();
//		//role1.setRoleId(1);
//		role1.setName("ROLE_USER");
//		userRoles.add(new UserRole(user1, role1));
//
//		userService.createUser(user1, userRoles);
//
//		userRoles.clear();
//
//		User user2 = new User();
//		user2.setName("Admin");
//		user2.setLastName("Admin");
//		user2.setUsername("admin");
//		user2.setPassword(passwordEncoder.encode("admin123"));
//		user2.setEmail("Admin@gmail.com");
//		Role role2 = new Role();
//		//role2.setRoleId(0);
//		role2.setName("ROLE_ADMIN");
//		userRoles.add(new UserRole(user2, role2));
//
//		userService.createUser(user2, userRoles);

    }
}
