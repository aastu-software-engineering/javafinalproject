package io.ruth.quizapp.services;

import io.ruth.quizapp.entities.Examinee;
import io.ruth.quizapp.entities.Quiz;
import io.ruth.quizapp.entities.Result;

public interface IExamineeService {
    Quiz takeQuiz(int examineeId,int quizId);
    Result seescore(int examineeId, int quizId);
    Quiz retakeQuiz(int examineeId, int quizId);
    boolean editProfile(Examinee ex, int examineeId);
    int register(Examinee ex);
}
