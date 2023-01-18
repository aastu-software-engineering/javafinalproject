package io.ruth.quizapp.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "admin")
public class Admin extends User {
    private String company;
    private String role;


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
