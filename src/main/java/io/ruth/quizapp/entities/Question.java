package io.ruth.quizapp.entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionId;
    private String title;
    private String answer;


    public Set<String> getChoices() {
        return choices;
    }

    public void setChoices(Set<String> choices) {
        this.choices = choices;
    }

    @ElementCollection
    private Set<String> choices = new HashSet<>();
    private double point;
    public Question(int questionId, String title, double point){
        this.questionId = questionId;
        this.title = title;
        this.point = point;
    }
    public Question(){

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


    public String getCorrectAnswer() {
        return answer;
    }


}
