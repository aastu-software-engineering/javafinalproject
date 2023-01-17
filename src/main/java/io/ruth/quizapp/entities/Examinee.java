package io.ruth.quizapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Examinee {
    @Id
    private String examineeId;
    private String profession;

}
