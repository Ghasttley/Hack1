package com.tuckersoft.branchengine;

import com.tuckersoft.branchengine.user.Account;
import com.tuckersoft.branchengine.user.CreateUserDTO;
import com.tuckersoft.branchengine.user.LoginRequestDTO;

import java.util.UUID;

public interface AuthRepository {
    String login(LoginRequestDTO loginRequestDTO);
    boolean validateToken(String token);
    String getUserFromToken(String token);
    void createUser(CreateUserDTO createUserDto);
    Account getUser(UUID id);
}