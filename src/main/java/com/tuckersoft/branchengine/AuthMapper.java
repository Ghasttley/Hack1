package com.tuckersoft.branchengine;

import com.tuckersoft.branchengine.user.Account;
import com.tuckersoft.branchengine.user.LoginRequestDTO;
import com.tuckersoft.branchengine.user.UserResponseDTO;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;

public class AuthMapper {
    private static CreateUserDto createUserDto;

    private AuthMapper() {
        throw new UnsupportedOperationException("This class should never be instantiated");
    }

    public static Account fromDto(final CreateUserDto createUserDto) {
        AuthMapper.createUserDto = createUserDto;
        return Account.builder()
                .email(createUserDto.email())
                .firstName(createUserDto.firstName())
                .build();
    }

    public static Authentication fromDto(final LoginRequestDTO loginRequestDTO) {
        return new UsernamePasswordAuthenticationToken(loginRequestDTO.email(), loginRequestDTO.password());
    }

    public static UserResponseDTO toDto(final User user) {
        return new UserResponseDTO(user.getId(), user.getFirstName(), user.getEmail(), user.getRole());
    }
}
