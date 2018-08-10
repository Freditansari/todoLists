package com.fredy.projectbackend.Security;

import com.fredy.projectbackend.Models.User;
import com.fredy.projectbackend.Models.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface UserService {
    User createUser(User user, Set<UserRole> userRoles);

}
