package io.ruth.quizapp.entities;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumns;

import java.util.ArrayList;

@Entity
public class MultipleChoice extends Question{
    @ElementCollection
    ArrayList<String>choices = new ArrayList<>();

    public MultipleChoice() {
        super();
    }
}
