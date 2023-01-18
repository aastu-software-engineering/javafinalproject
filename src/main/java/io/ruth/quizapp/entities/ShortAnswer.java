package io.ruth.quizapp.entities;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

import java.util.ArrayList;

@Entity
public class ShortAnswer extends Question{
    @ElementCollection
    ArrayList<String>possibleAnswers = new ArrayList<>();

    public ShortAnswer() {

    }
}
