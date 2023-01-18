package io.ruth.quizapp.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class TestClass {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Admins");
        EntityManager em = entityManagerFactory.createEntityManager();
        Admin admin = new Admin();
        admin.setCompany("helo");
        admin.setRole("admin");

        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
    }
}
