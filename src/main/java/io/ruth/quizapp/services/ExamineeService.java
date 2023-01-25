package io.ruth.quizapp.services;
import io.ruth.quizapp.entities.Examinee;
import io.ruth.quizapp.entities.Quiz;
import io.ruth.quizapp.entities.Result;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;
public class ExamineeService implements IExamineeService{
    private EntityManager em;
    public ExamineeService() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin");
        em = emf.createEntityManager();
    }
    @Override
    public boolean editProfile(Examinee ex, int examineeId) {
        Examinee examinee = em.find(Examinee.class, examineeId);
        if(examinee != null){
            examinee.setName(ex.getName());
            examinee.setEmail(ex.getEmail());
            examinee.setPassword(ex.getPassword());
            em.persist(examinee);
            em.getTransaction().commit();
            return true;
        }else {
            return false;
        }
    }
    @Override
    public int register(Examinee ex) {
        try {
            em.getTransaction().begin();
            em.persist(ex);
            em.getTransaction().commit();
            return ex.getUserId();
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public Examinee getInformation(int examineeId) {
        Examinee ex = em.find(Examinee.class, examineeId);
        return ex;
    }

}
