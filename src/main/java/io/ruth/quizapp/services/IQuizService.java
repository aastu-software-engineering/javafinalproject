package io.ruth.quizapp.services;

import io.ruth.quizapp.DTO.Answer;
import io.ruth.quizapp.DTO.CreateQuizDto;
import io.ruth.quizapp.DTO.ScoreResponseDto;
import io.ruth.quizapp.entities.Quiz;
import io.ruth.quizapp.entities.Result;

import java.util.ArrayList;

public interface IQuizService {
    Quiz takeQuiz(int examineeId,int quizId);
    Result seeScore(int examineeId, int quizId);
    Quiz retakeQuiz(int examineeId, int quizId);
    ScoreResponseDto gradeQuiz(int examineeId, int quizId, ArrayList<Answer> providedAns);

    Quiz createQuiz(CreateQuizDto quizDto);

    ArrayList<Quiz> getAllQuizzes(int id);

    Object getQuizStats(int adminId, int quizId);
}
