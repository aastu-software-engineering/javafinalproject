package io.ruth.quizapp.services;

import io.ruth.quizapp.entities.Admin;
import io.ruth.quizapp.entities.Question;
import io.ruth.quizapp.entities.Quiz;
import java.util.ArrayList;
import java.util.List;

public interface IAdminService {
    int quizCreate(ArrayList<Question> questionList);
    boolean deleteQuiz(int id);
    ArrayList<Quiz>  getQuizzes(int adminId);
    Quiz getQuiz(int id);
    boolean editProfile(Admin admin, int adminId);
    int registerAdmin(Admin admin);
}
