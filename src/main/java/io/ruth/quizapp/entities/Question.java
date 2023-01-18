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

}
