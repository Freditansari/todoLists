package com.fredy.projectbackend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "notes")
public class Note {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Id;

    private String Notes;

    @Column(name= "notesDate")
    private Instant notesDate;

    @ManyToOne
    @JoinColumn(name="task_id")
    @JsonIgnore
    private Task task;

    public Note(String notes, Instant notesDate, Task task) {
        Notes = notes;
        this.notesDate = notesDate;
        this.task = task;
    }

    public Note() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public Instant getNotesDate() {
        return notesDate;
    }

    public void setNotesDate(Instant notesDate) {
        this.notesDate = notesDate;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
