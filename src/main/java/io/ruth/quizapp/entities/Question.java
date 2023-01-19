package io.ruth.quizapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    private int questionId;
    private String title;
    private String answer;
    private double point;
    @ManyToOne
    @JoinColumn(name = "quizId")
    public Quiz quiz;
    public Question(int questionId, String title, double point, Quiz quiz){
        this.questionId = questionId;
        this.title = title;
        this.point = point;
        this.quiz = quiz;
    }
    public Question(){

    }
    public Question(Quiz quiz){

        this.quiz = quiz;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public String getCorrectAnswer() {
        return answer;
    }
}
