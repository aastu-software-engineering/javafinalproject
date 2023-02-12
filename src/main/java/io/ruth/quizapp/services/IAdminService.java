package io.ruth.quizapp.services;

import io.ruth.quizapp.DTO.LoginDto;
import io.ruth.quizapp.entities.Admin;

public interface IAdminService {
    boolean editProfile(Admin admin, int adminId);
    int registerAdmin(Admin admin) throws Exception;

    Admin login(LoginDto loginDto);
}
