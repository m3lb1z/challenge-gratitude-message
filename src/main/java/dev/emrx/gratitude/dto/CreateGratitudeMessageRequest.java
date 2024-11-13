package dev.emrx.gratitude.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto que representa una solicitud para crear un mensaje de gratitud")
public record CreateGratitudeMessageRequest(
    @NotBlank(message = "El mensaje no puede estar vacío")
    @Size(max = 500, message = "El mensaje no puede tener más de 500 caracteres")
    @Schema(description = "El contenido del mensaje de gratitud", example = "Gracias por tu ayuda")
    String message,

    @NotBlank(message = "El nombre del remitente no puede estar vacío")
    @Size(max = 100, message = "El nombre del remitente no puede tener más de 100 caracteres")
    @Schema(description = "El nombre del remitente del mensaje", example = "Juan Pérez")
    String senderName
) {}
