package io.ruth.quizapp.services;

import io.ruth.quizapp.entities.Admin;
import io.ruth.quizapp.entities.Question;
import io.ruth.quizapp.entities.Quiz;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.validation.constraints.Null;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class AdminService {
    EntityManager em;
    public AdminService(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin");
        this.em = emf.createEntityManager();
    }

    int quizCreate(Set<Question> questionList, boolean retake, int minutes){
        Quiz q = new Quiz();
        q.setMinutes(minutes);
        q.setRetake(retake);
        q.setQuestions(questionList);
        em.getTransaction().begin();
        em.persist(q);
        em.getTransaction().commit();
        return q.getQuizId();
    }
    boolean deleteQuiz( int id){
        em.getTransaction().begin();
        em.remove(id);
        em.getTransaction().commit();
        return true;
    }
    ArrayList<Quiz> getQuizzes(int adminId){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Quiz> criteria = builder.createQuery(Quiz.class);
        criteria.from(Quiz.class);
        List<Quiz> quizzes = em.createQuery(criteria).getResultList();
        ArrayList<Quiz> filtered = new ArrayList<>();
        Admin ad = em.find(Admin.class, adminId);
        for(int i = 0; i< quizzes.size(); i++){
            if (quizzes.get(i).getPreparedBy().equals(ad)){
                filtered.add(quizzes.get(i));
            }
        }
        return filtered;
    }
    Quiz getQuiz(int id){
        Quiz qu = em.find(Quiz.class, id);
        return qu;
    }
    boolean editProfile(Admin admin,int adminId){
        Admin ad = em.find(Admin.class,adminId);
        ad.setName(admin.getName());
        ad.setRole(admin.getRole());
        ad.setUserId(admin.getUserId());
        ad.setEmail(admin.getEmail());
        ad.setCompany(admin.getCompany());
        ad.setPassword(admin.getPassword());

        em.getTransaction().begin();
        em.persist(ad);
        em.getTransaction().commit();
        return true;
    }
    int registerAdmin(Admin admin) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        map.put("email", admin.getEmail());
        Admin ad = em.find(Admin.class,map);
        if(ad != null){
            throw new Exception("Email already exists!");
        }
        em.getTransaction().begin();
        em.persist(admin);
        em.getTransaction().commit();
        return admin.getUserId();
    }
}
