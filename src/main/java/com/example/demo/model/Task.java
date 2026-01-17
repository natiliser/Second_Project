package com.example.demo.model;



import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name="Task")
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public @NotBlank @Length(min = 10, max = 100) String getContent() {
        return content;
    }

    public void setContent(@NotBlank @Length(min = 10, max = 100) String content) {
        this.content = content;
    }

    public @NotBlank @Length(min = 5, max = 30) String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank @Length(min = 5, max = 30) String title) {
        this.title = title;
    }

    public @Min(1) @Max(100) Integer getPriority() {
        return priority;
    }

    public void setPriority(@Min(1) @Max(100) Integer priority) {
        this.priority = priority;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @NotBlank
    @Length(min = 5, max = 30)
    private String title;

    @NotBlank
    @Length(min = 10, max = 100)
    private String content;

    @Min(1) @Max(100)
    private Integer priority;

    private Boolean done;

//    public Task() {}

    public Task(String title, String content, Integer priority) {
        this.title = title;
        this.content = content;
        this.priority = priority;
        this.done = false;
    }
}
