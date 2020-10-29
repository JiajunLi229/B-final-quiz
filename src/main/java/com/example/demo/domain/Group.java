package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
@Entity
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Trainee> traineeList;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Trainer> trainerList;
}
