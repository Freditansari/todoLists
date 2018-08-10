package com.fredy.projectbackend.Repositories;

import com.fredy.projectbackend.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unused")
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

     List<Task> getTasksByHolderName(String holderName);
}
