package io.ruth.quizapp.services;

import io.ruth.quizapp.DTO.LoginDto;
import io.ruth.quizapp.entities.Examinee;

public interface IExamineeService {
    boolean editProfile(Examinee ex, int examineeId);
    Examinee register(Examinee ex);
    Examinee getInformation(int examineeId);

    Examinee login(LoginDto ex);
}
