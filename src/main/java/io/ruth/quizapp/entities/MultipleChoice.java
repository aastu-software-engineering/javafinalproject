package io.ruth.quizapp.entities;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;


import java.util.ArrayList;

@Entity
public class MultipleChoice extends Question{
    @ElementCollection
    ArrayList<String>choices = new ArrayList<>();

    public MultipleChoice() {
        super();
    }
}
