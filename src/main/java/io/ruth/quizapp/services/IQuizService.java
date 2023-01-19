package io.ruth.quizapp.services;

import io.ruth.quizapp.DTO.Answer;
import io.ruth.quizapp.entities.Examinee;
import io.ruth.quizapp.entities.Quiz;
import io.ruth.quizapp.entities.Result;

import java.util.ArrayList;

public interface IQuizService {
    Quiz takeQuiz(int examineeId,int quizId);
    Result seeScore(int examineeId, int quizId);
    Quiz retakeQuiz(int examineeId, int quizId);
    float gradeQuiz(int examineeId, int quizId, ArrayList<Answer> providedAns);
}
