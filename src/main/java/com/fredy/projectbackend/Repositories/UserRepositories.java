package com.fredy.projectbackend.Repositories;

import com.fredy.projectbackend.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<User, Long> {
}
