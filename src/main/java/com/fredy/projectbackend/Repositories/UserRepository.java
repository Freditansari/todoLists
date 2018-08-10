package com.fredy.projectbackend.Repositories;

import com.fredy.projectbackend.Models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String userName);



}
