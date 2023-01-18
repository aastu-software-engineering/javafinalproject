package io.ruth.quizapp.services;

import io.ruth.quizapp.entities.Examinee;
import io.ruth.quizapp.entities.Quiz;

public interface IExamineeService {
    Quiz takeQuiz(int examineeId,int quizId);
    float seescore(int examineeId, int quizId);
    Quiz retakeQuiz(int examineeId, int quizId);
    boolean editProfile(Examinee ex, int examineeId);
    int register(Examinee ex);
}
