package io.ruth.quizapp.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="quiz")
public class Quiz {
    @Id
    @Column(name = "quizId")
    private int quizId;
    private boolean retake;
    @ManyToOne
    private Admin preparedBy;
    private int totalMark;
    private int minutes;
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Question> questions = new LinkedHashSet<>();
    public int getQuizId() {
        return quizId;
    }
    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public boolean isRetake() {
        return retake;
    }

    public void setRetake(boolean retake) {
        this.retake = retake;
    }

    public int getMinutes() {
        return minutes;
    }
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
    public Set<Question> getQuestions() {
        return questions;
    }
    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
    public Admin getPreparedBy() {
        return preparedBy;
    }
    public void setPreparedBy(Admin preparedBy) {
        this.preparedBy = preparedBy;
    }
}
