package com.project.backend.Service;

import com.project.backend.Dto.LoginDTO;
import com.project.backend.Dto.UserDTO;
import com.project.backend.response.LoginResponse;

public interface UserService {

    String addUser(UserDTO userDTO);

    LoginResponse loginUser(LoginDTO loginDTO);
    
}
