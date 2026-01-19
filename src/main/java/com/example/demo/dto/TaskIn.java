package com.example.demo.dto;

import com.example.demo.model.Task;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore; // ליתר ביטחון

public class TaskIn implements Serializable {

    @NotBlank
    @Length(min = 5, max = 30)
    private String title;

    @NotBlank
    @Length(min = 10, max = 100)
    private String content;

    @Min(1) @Max(100)
    private Integer priority;

    // --- Getters & Setters (אלו חייבים להישאר רגילים) ---

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
    // --- מתודות המרה (שינוי שמות קריטי!) ---

    // שינינו מ-getTask ל-toEntity
    // הסרנו את ה-@JsonIgnore כי שינוי השם מספיק, אבל אפשר להשאיר ליתר ביטחון
    @JsonIgnore
    public Task toEntity(TaskIn taskIn) {
        return new Task(
                this.title,
                this.content,
                this.priority
        );
    }

    // שינינו מ-setTask ל-updateEntity
    // זה ימנע מה-Swagger לחשוב שזה שדה שצריך לשלוח
    @JsonIgnore
    public void updateEntity(Task task) {
        task.setTitle(this.title);
        task.setContent(this.content);
        task.setPriority(this.priority);
    }
}