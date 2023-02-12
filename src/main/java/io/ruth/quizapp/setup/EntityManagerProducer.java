package io.ruth.quizapp.setup;

import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


public class EntityManagerProducer {
    @Produces
    @PersistenceContext(unitName = "my-persistence-unit")
    @MySQLDatabase
    private EntityManager entityManager;

}