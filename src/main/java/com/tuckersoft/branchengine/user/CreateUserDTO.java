package com.tuckersoft.branchengine.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserDTO(
        @Email
        @NotBlank
        String email,

        @NotBlank
        String firstName,

        @NotBlank
        String password
) {
}