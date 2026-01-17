package com.example.demo.dto;

import com.example.demo.model.Task;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class TaskIn implements Serializable {

    public @NotBlank @Length(min = 5, max = 30) String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank @Length(min = 5, max = 30) String title) {
        this.title = title;
    }

    public @NotBlank @Length(min = 10, max = 100) String getContent() {
        return content;
    }

    public void setContent(@NotBlank @Length(min = 10, max = 100) String content) {
        this.content = content;
    }

    public @Min(1) @Max(100) Integer getPriority() {
        return priority;
    }

    public void setPriority(@Min(1) @Max(100) Integer priority) {
        this.priority = priority;
    }

    @NotBlank
    @Length(min = 5, max = 30)
    private String title;

    @NotBlank
    @Length(min = 10, max = 100)
    private String content;

    @Min(1) @Max(100)
    private Integer priority;



    public Task getTask(TaskIn taskIn){
        return new Task(
                taskIn.getTitle(),
                taskIn.getContent(),
                taskIn.getPriority()
        );
    }

    public void setTask(Task task){
        task.setTitle(title);
        task.setContent(content);
        task.setPriority(priority);
    }
}
