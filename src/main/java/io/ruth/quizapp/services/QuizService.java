package io.ruth.quizapp.services;

import io.ruth.quizapp.DTO.Answer;
import io.ruth.quizapp.DTO.CreateQuizDto;
import io.ruth.quizapp.DTO.ScoreResponseDto;
import io.ruth.quizapp.Emf;
import io.ruth.quizapp.entities.*;
import jakarta.annotation.ManagedBean;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

import java.util.*;
@ManagedBean
public class QuizService implements IQuizService {
    private EntityManager em;

    public QuizService() {
        EntityManagerFactory emf = Emf.getInstance().getFactory();
        em = emf.createEntityManager();
    }

    @Override
    public Quiz takeQuiz(int examineeId, int quizId) {

        //TODO: set start time for quiz
        try {
            Quiz q = em.find(Quiz.class, quizId);
            Examinee e = em.find(Examinee.class, examineeId);
            Date date = new Date();

            if (q.isRetake() == false) {
                Map<String, Integer> map = new HashMap<>();
                map.put("examineeId", examineeId);
                map.put("quizId", quizId);
               // Result r = em.find(Result.class, map);
            }
            return q;
        }   catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error occurred while taking quiz");
        }

    }

    private void startSession(int examineeId, int quizId) {

    }

    @Override
    public Result seeScore(int examineeId, int quizId) {
        Map<String, Integer> map = new HashMap<>();
        map.put("examineeId", examineeId);
        map.put("quizId", quizId);
        Result result = em.find(Result.class, map);
        if (result != null) {
            return result;
        }
        return null;
    }

    @Override
    public Quiz retakeQuiz(int examineeId, int quizId) {
        return takeQuiz(examineeId, quizId);
    }
    @Override
    public ScoreResponseDto gradeQuiz(int examineeId, int quizId, ArrayList<Answer> answers) {
        // TODO: saving the result to database
        Quiz q = em.find(Quiz.class, quizId);
        ScoreResponseDto scr = new ScoreResponseDto();
        double score = 0;
        double total = 0;
        Set<Question> questions = q.getQuestions();

        for (Question question : questions) {
            for (Answer answer : answers) {
                ScoreResponseDto.Checks check = new ScoreResponseDto.Checks();
                check.correctAnswer = question.getCorrectAnswer();
                if (question.getQuestionId() == answer.getQuestionId()) {

                    if (question.getAnswer().equals(answer.getProvidedAnswer())) {
                        score += question.getPoint();
                    }
                    total += question.getPoint();
                }

            }
        }
        scr.setScore(((double) score/(double) total)*100);
        Result result = new Result();
        result.setExaminee(em.find(Examinee.class, examineeId));
        result.setQuiz(q);
        result.setScore(score/total);
        em.getTransaction().begin();
        em.persist(result);
        em.getTransaction().commit();
        return scr;
    }
    public Quiz createQuiz(CreateQuizDto createQuizDto){

        System.out.println("QuizService.createQuiz()");
        try {
            Quiz quiz = new Quiz();
            quiz.setName(createQuizDto.getName());
            quiz.setMinutes(createQuizDto.getMinutes());
            quiz.setTotalMark(createQuizDto.getTotalMark());
            quiz.setRetake(createQuizDto.isRetake());
            Admin admin = em.find(Admin.class, createQuizDto.getPreparedBy());
            quiz.setPreparedBy(admin);
            quiz.setQuestions(createQuizDto.getQuestions());
            em.getTransaction().begin();
            for (Question question : createQuizDto.getQuestions()) {
                em.persist(question);
            }
            em.persist(quiz);
            em.getTransaction().commit();
            return quiz;
        } catch (Exception e) {
            System.out.println(e.getMessage() + " " + e.getCause());
            e.printStackTrace();
            throw new RuntimeException("Error occurred while creating quiz");
        }
    }

    @Override
    public ArrayList<Quiz> getAllQuizzes(int adminId) {
        System.out.println("QuizService.getAllQuizzes()");
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Quiz> criteria = builder.createQuery(Quiz.class);
        criteria.from(Quiz.class);
        List<Quiz> quizzes = em.createQuery(criteria).getResultList();
        ArrayList<Quiz> filtered = new ArrayList<>();
        Admin ad = em.find(Admin.class, adminId);
        for(int i = 0; i< quizzes.size(); i++){
            System.out.println(quizzes.get(i));
            if(quizzes.get(i).getPreparedBy() != null){
                if (quizzes.get(i).getPreparedBy().getUserId() == (ad.getUserId())){
                    filtered.add(quizzes.get(i));
                }
            }

        }
        return filtered;
    }

    @Override
    public Object getQuizStats(int adminId, int quizId) {
        // get all examinees who took the quiz
        // get all examinees who took the quiz and their scores
        // get all examinees who took the quiz and their scores and the time they took
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Result> criteria = builder.createQuery(Result.class);
        criteria.from(Result.class);
        List<Result> results = em.createQuery(criteria).getResultList();
        ArrayList<Result> filtered = new ArrayList<>();
        for(int i = 0; i< results.size(); i++){
            if(results.get(i).getQuiz().getQuizId() == quizId){
                filtered.add(results.get(i));
            }
        }
        return filtered;
    }
}
