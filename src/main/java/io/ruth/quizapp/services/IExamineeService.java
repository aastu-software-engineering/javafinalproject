package io.ruth.quizapp.services;

import io.ruth.quizapp.entities.Examinee;
import io.ruth.quizapp.entities.Quiz;
import io.ruth.quizapp.entities.Result;

public interface IExamineeService {
    boolean editProfile(Examinee ex, int examineeId);
    int register(Examinee ex);
    Examinee getInformation(int examineeId);
}
