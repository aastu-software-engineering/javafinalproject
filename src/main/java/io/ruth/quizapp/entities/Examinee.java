package io.ruth.quizapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "examinee")
@NamedQuery(name = "Examinee.findByEmail", query = "SELECT e FROM Examinee e WHERE e.email = :email")
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
