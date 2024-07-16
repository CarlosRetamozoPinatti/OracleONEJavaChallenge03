package com.forohub.ForoHub.domain.topics;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataCreateTopic(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotNull
        Long idUser,
        @NotNull
        Long idCourse
) {
}
