package io.ruth.quizapp.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="quiz")
public class Quiz {
    @Id
    @Column(name = "quizId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int quizId;
    private boolean retake;
    private String name;
    @ManyToOne
    private Admin preparedBy;
    private int totalMark;
    private int minutes;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;
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

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalMark() {
        return totalMark;
    }
}
