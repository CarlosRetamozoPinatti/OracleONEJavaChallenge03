package com.forohub.ForoHub.domain.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DataRecordsUsers(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String password
) {
}
