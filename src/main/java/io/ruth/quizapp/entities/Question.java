package io.ruth.quizapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Question {
    @Id
    private int questionId;
    private String title;
    private String answer;
    private double point;
    public Question(int questionId, String title, double point){
        this.questionId = questionId;
        this.title = title;
        this.point = point;
    }
    public Question(){

    }

}
