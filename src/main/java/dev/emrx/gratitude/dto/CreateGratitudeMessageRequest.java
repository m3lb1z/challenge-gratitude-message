package dev.emrx.gratitude.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateGratitudeMessageRequest(
    @NotBlank(message = "El mensaje no puede estar vacío")
    @Size(max = 500, message = "El mensaje no puede tener más de 500 caracteres")
    String message,

    @NotBlank(message = "El nombre del remitente no puede estar vacío")
    @Size(max = 100, message = "El nombre del remitente no puede tener más de 100 caracteres")
    String senderName
) {}
