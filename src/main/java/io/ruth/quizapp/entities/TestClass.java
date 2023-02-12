package io.ruth.quizapp.entities;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Set;


public class TestClass {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("admin");
        EntityManager em = entityManagerFactory.createEntityManager();
        Quiz quiz = new Quiz();
        quiz.setName("Quiz 1");
        quiz.setRetake(true);
        quiz.setMinutes(10);
        quiz.setTotalMark(10);
        Admin admin = em.find(Admin.class, 0);
        Question question = new Question();
        question.setTitle("What is the capital of Nigeria?");
        question.setAnswer("Abuja");
        question.setChoices(Set.of("Abuja", "Lagos", "Ibadan", "Kano"));
        question.setPoint(5);
        Question question2 = new Question();
        question2.setTitle("What is the capital of Nigeria?");
        question2.setAnswer("Abuja");
        question2.setPoint(5);
        question2.setChoices(Set.of("Abuja", "Lagos", "Ibadan", "Kano"));
        Set<Question> q = Set.of(question, question2);
        quiz.setQuestions(q);
        quiz.setPreparedBy(admin);
        em.getTransaction().begin();
        em.persist(quiz);
        em.persist(question);
        em.persist(question2);
        em.getTransaction().commit();

    }
}
