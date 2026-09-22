package com.tuckersoft.branchengine.user;

import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String name,
        String email,
        Role role
) {
}