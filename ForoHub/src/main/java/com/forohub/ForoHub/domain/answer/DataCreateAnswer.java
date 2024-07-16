package com.forohub.ForoHub.domain.answer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataCreateAnswer(
        @NotBlank
        String message,
        @NotNull
        Long idUser,
        @NotNull
        Long idTopic,
        Boolean solved
) {
}
