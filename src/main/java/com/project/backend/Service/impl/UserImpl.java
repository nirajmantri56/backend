package com.project.backend.Service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.backend.Dto.LoginDTO;
import com.project.backend.Dto.UserDTO;
import com.project.backend.Entity.User;
import com.project.backend.Repo.UserRepo;
import com.project.backend.Service.UserService;
import com.project.backend.response.LoginResponse;

@Service
public class UserImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDTO userDTO) {
        Optional<User> existingUser = userRepo.findByEmail(userDTO.getEmail());

        if(existingUser.isPresent()) {
            return "User already exists with this email";
        }

        User user = new User(
            userDTO.getUserid(),
            userDTO.getEmail(),
            this.passwordEncoder.encode(userDTO.getPassword())
        );

        userRepo.save(user);

        return "User added Successfully";
    }

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        Optional<User> userOptional = userRepo.findByEmail(loginDTO.getEmail());
        if (userOptional.isPresent()) {
            User user1 = userOptional.get();
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {

                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exists", false);
        }
    }
    
}
