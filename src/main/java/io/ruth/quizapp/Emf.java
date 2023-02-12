package io.ruth.quizapp;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Emf {

    private static volatile Emf theInstance = null;
    private EntityManagerFactory entityManagerFactory = null;

    private Emf() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("admin", System.getProperties());
            System.out.println("EntityManagerFactory created");
            //InitialContext context = new InitialContext();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static synchronized Emf getInstance() {
        if (theInstance == null) {
            theInstance = new Emf();
        }
        return theInstance;
    }

    public EntityManagerFactory getFactory() {
        return entityManagerFactory;
    }
}