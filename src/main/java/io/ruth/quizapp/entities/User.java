package io.ruth.quizapp.entities;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class User {
    @Id
    private int userId;
    private String name;
    private String email;
    private String password;

}
