package io.ruth.quizapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "examinee")
public class Examinee extends User{
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    private String profession;

    public Examinee(String profession) {
        this.profession = profession;
    }
    public Examinee(){

    }
}
