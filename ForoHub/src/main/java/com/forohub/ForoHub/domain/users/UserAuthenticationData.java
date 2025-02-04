package com.forohub.ForoHub.domain.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserAuthenticationData(
        @Email
        String email,
        @NotBlank
        String password
) {
}
