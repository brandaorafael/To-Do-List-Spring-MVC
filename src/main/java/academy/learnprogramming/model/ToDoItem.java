package academy.learnprogramming.model;

import lombok.*;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id") // @Data already set Equals and HashCode, but that way we can choose the parameter
public class ToDoItem {

    private int id;
    private String title;
    private String details;
    private LocalDate deadline;

    public ToDoItem(String title, String details, LocalDate deadline) {
        this.title = title;
        this.details = details;
        this.deadline = deadline;
    }
}
