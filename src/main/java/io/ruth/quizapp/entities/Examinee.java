package io.ruth.quizapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "examinee")
public class Examinee extends User{
    private String profession;

}
