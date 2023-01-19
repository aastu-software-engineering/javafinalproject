package io.ruth.quizapp.DTO;

import java.util.ArrayList;

public class SubmitQuizDto {
    private String quizId;
    private String examineeId;
    private ArrayList<Answer> answers = new ArrayList<>();
    public String getQuizId() {
        return quizId;
    }
    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }
    public String getExamineeId() {
        return examineeId;
    }
    public void setExamineeId(String examineeId) {
        this.examineeId = examineeId;
    }
    public ArrayList<Answer> getAnswers() {
        return answers;
    }
    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }
}
