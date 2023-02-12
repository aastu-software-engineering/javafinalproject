package io.ruth.quizapp.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "admin")
public class Admin extends User {
    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {

        this.company = company;
    }
}
