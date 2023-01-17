package io.ruth.quizapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;

@Entity
public class Quiz {
    @Id
    private String quizId;
    @OneToMany(mappedBy = "Quiz")
    ArrayList<Question>questions;
}
