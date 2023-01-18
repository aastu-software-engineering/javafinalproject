package io.ruth.quizapp.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="quiz")
public class Quiz {
    @Id
    @Column(name = "quizId")
    private int quizId;
    private boolean retake;
    private int minutes;
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "quiz_id")
    private Set<Question> questions = new LinkedHashSet<>();

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
