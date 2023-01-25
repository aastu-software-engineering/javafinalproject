package io.ruth.quizapp.services;
import io.ruth.quizapp.DTO.Answer;
import io.ruth.quizapp.DTO.ScoreResponseDto;
import io.ruth.quizapp.entities.Examinee;
import io.ruth.quizapp.entities.Question;
import io.ruth.quizapp.entities.Quiz;
import io.ruth.quizapp.entities.Result;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.*;

public class QuizService implements IQuizService {
    private EntityManager em;

    public QuizService() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin");
        em = emf.createEntityManager();
    }

    @Override
    public Quiz takeQuiz(int examineeId, int quizId) {
        //TODO: set start time for quiz
        Quiz q = em.find(Quiz.class, quizId);
        Examinee e = em.find(Examinee.class, examineeId);
        Date date = new Date();

        if (q.isRetake() == false) {
            Map<String, Integer> map = new HashMap<>();
            map.put("examineeId", examineeId);
            map.put("quizId", quizId);
            Result r = em.find(Result.class, map);
            if (r != null) {
                return null;
            }
        }
        return q;
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
    public float gradeQuiz(int examineeId, int quizId, ArrayList<Answer> answers) {
        // TODO: saving the result to database
        Quiz q = em.find(Quiz.class, quizId);
        ScoreResponseDto scr = new ScoreResponseDto();
        int score = 0;
        int total = 0;
        Set<Question> questions = q.getQuestions();

        for (Question question : questions) {
            for (Answer answer : answers) {
                ScoreResponseDto.Checks check = new ScoreResponseDto.Checks();
                check.correctAnswer = question.getCorrectAnswer();
                if (question.getQuestionId() == answer.getQuestionId()) {
                    if (question.getAnswer().equals(answer.getProvidedAnswer())) {

                        score += question.getPoint();
                    }
                }
                total += question.getPoint();
            }
        }
        scr.setScore(score);
        return 21;
    }
}
