package com.diego.library.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record LoginData(
        @NotBlank
        String login,
        @NotBlank
        String password) {
}
