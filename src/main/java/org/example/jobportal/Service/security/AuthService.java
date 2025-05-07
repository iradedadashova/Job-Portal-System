package org.example.jobportal.Service.security;

import org.example.jobportal.Model.DTO.security.AuthResponse;
import org.example.jobportal.Model.DTO.security.LoginDTO;
import org.example.jobportal.Model.DTO.security.RegisterDTO;
import org.example.jobportal.Model.Entity.User;

import java.util.Optional;

public interface AuthService {
    AuthResponse register(RegisterDTO request);
    AuthResponse login(LoginDTO request);
}
