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
    public Quiz takeQuiz(int examineeId, int quizId) {
        //TODO: set start time for quiz
        Quiz q = em.find(Quiz.class, quizId);
        Examinee e = em.find(Examinee.class, examineeId);
        if(q.isRetake() == false){
            Map<String, Integer> map = new HashMap<>();
            map.put("examineeId", examineeId);
            map.put("quizId", quizId);
            Result r = em.find(Result.class, map);
            if(r != null){
                return null;
            }
        }
        return q;
    }
    @Override
    public Result seescore(int examineeId, int quizId) {
        Map<String, Integer> map = new HashMap<>();
        map.put("examineeId", examineeId);
        map.put("quizId", quizId);
        Result result = em.find(Result.class, map);
        if(result != null){
            return result;
        }
        return null;
    }
    @Override
    public Quiz retakeQuiz(int examineeId, int quizId) {
        return takeQuiz(examineeId, quizId);
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
        em.getTransaction().begin();
        em.persist(ex);
        em.getTransaction().commit();
        return ex.getUserId();
    }
}
