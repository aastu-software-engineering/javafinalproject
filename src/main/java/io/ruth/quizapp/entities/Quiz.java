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

    public Admin getPreparedBy() {
        return preparedBy;
    }

    public void setPreparedBy(Admin preparedBy) {
        this.preparedBy = preparedBy;
    }

    @ManyToOne
    private Admin preparedBy;
    private boolean retake;

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public void setRetake(boolean retake) {
        this.retake = retake;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getQuizId() {
        return quizId;
    }

    public boolean isRetake() {
        return retake;
    }

    public int getMinutes() {
        return minutes;
    }

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
