package io.ruth.quizapp.DTO;

import io.ruth.quizapp.entities.Question;

import java.util.HashSet;
import java.util.Set;
public class CreateQuizDto {
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private boolean retake;
    private int preparedBy;
    private int totalMark;
    private int minutes;
    private Set<Question> questions = new HashSet<>();

    public CreateQuizDto(boolean retake, int preparedBy, int totalMark, int minutes, Set<Question> questions) {
        this.retake = retake;
        this.preparedBy = preparedBy;
        this.totalMark = totalMark;
        this.minutes = minutes;
        this.questions = questions;
    }
    public CreateQuizDto() {
    }

    public boolean isRetake() {
        return retake;
    }

    public void setRetake(boolean retake) {
        this.retake = retake;
    }

    public int getPreparedBy() {
        return preparedBy;
    }

    public void setPreparedBy(int preparedBy) {
        this.preparedBy = preparedBy;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
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
}
