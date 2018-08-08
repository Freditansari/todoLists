package com.fredy.projectbackend.Models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tasks")
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Id;
    @Column(name = "task")
    private String task;
    @Column(name="holderName")
    private String holderName;

    public Task() {
    }

    public Task(String task, String holderName) {
        this.task = task;
        this.holderName = holderName;
    }

    public Long getId() {
        return Id;
    }


    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        holderName = holderName;
    }
}
