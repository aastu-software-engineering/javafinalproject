package io.ruth.quizapp.DTO;

public class Answer {
    private int questionId;
    private String providedAnswer;
    public int getQuestionId() {
        return questionId;
    }
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
    public String getProvidedAnswer() {
        return providedAnswer;
    }
    public void setProvidedAnswer(String providedAnswer) {
        this.providedAnswer = providedAnswer;
    }
}
