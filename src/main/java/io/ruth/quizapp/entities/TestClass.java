package io.ruth.quizapp.entities;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;



public class TestClass {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("admin");
        EntityManager em = entityManagerFactory.createEntityManager();
        Examinee user = new Examinee();
        user.setName("Ruth");
        user.setEmail("ruth@gmail.com");
        user.setProfession("Software Engineer");
        user.setPassword("123456");


        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

    }
}
