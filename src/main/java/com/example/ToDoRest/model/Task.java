package com.example.ToDoRest.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotNull
    @NotBlank(message = "Title is required")
    private String title;
    @Column
    @NotNull
    @NotBlank(message = "Description is required")
    private String description;
}
