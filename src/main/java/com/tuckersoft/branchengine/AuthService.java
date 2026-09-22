package com.tuckersoft.branchengine;

import com.tuckersoft.branchengine.user.Account;
import com.tuckersoft.branchengine.user.AccountRepository;
import com.tuckersoft.branchengine.user.CreateUserDTO;
import com.tuckersoft.branchengine.user.LoginRequestDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.logging.Logger;

@Service
public class AuthService implements AuthRepository, UserDetailsService {
    private static final Logger logger = LogManager.getLogger(AuthService.class);

    private final AccountRepository userRepository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationConfiguration authenticationConfiguration;


    public AuthService(
            AccountRepository userRepository,
            TokenService tokenService,
            PasswordEncoder passwordEncoder,
            AuthenticationConfiguration authenticationConfiguration
    ) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationConfiguration = authenticationConfiguration;
    }

    @Override
    public void createUser(final CreateUserDTO createUserDto) {
        final Account createUser = AuthMapper.fromDto(createUserDto);
        createUser.setPassword(passwordEncoder.encode(createUserDto.password()));
        final Account user = userRepository.save(createUser);
        logger.info("[USER] : User successfully created with id {}", Account.getId());
    }


    @Override
    public Account getUser(final UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("[USER] : User not found with id {}", id);
                    return new FincasException(FincasErrorMessage.USER_NOT_FOUND);
                });
    }

    @Override
    public String login(final LoginRequestDTO loginRequest) {
        try {
            final AuthenticationManager authenticationManager = authenticationConfiguration.getAuthenticationManager();
            final Authentication authRequest = AuthMapper.fromDto(loginRequest);
            final Authentication authentication = authenticationManager.authenticate(authRequest);
            return tokenService.generateToken(authentication);

        } catch (Exception e) {
            logger.error("[USER] : Error while trying to login", e);
            throw new ProviderNotFoundException("Error while trying to login");
        }
    }


    @Override
    public boolean validateToken(final String token) {
        return tokenService.validateToken(token);
    }

    @Override
    public String getUserFromToken(final String token) {
        return tokenService.getUserFromToken(token);
    }

    @Override
    public UserDetails loadUserByUsername(final String username) {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> {
                    logger.error("[USER] : User not found with email {}", username);
                    return new UsernameNotFoundException("User not found");
                });
    }
}