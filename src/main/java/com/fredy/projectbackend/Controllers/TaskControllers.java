package com.fredy.projectbackend.Controllers;

import com.fredy.projectbackend.Models.Task;
import com.fredy.projectbackend.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class TaskControllers {

    @Autowired
    TaskRepository taskRepo;

    @PostMapping(value = "/insertTask", produces="application/json")
    public Object addTask(Principal principal, @RequestParam("task") String task){
        taskRepo.save(new Task(task, principal.getName()));
        return "{\"Message\":\"Success\"}";
    }

    @PostMapping(value = "/getTasks", produces ="application/json")
    public List<Task> getTasks(Principal principal){
        return taskRepo.getTasksByHolderName(principal.getName());

    }
}
