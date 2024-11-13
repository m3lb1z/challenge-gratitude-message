package dev.emrx.gratitude.dto;

import java.time.LocalDateTime;
import dev.emrx.gratitude.model.GratitudeMessage;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto que representa un mensaje de gratitud")
public record GratitudeMessageDTO(
    @Schema(description = "El ID del mensaje", example = "1")
    Long id,

    @Schema(description = "El contenido del mensaje de gratitud", example = "Querida Alexandra, gracias por tus palabras de aliento durante los momentos difíciles. Significan mucho para mí.")
    String message,

    @Schema(description = "El nombre del remitente del mensaje", example = "Sofía Rodríguez")
    String senderName,

    @Schema(description = "La fecha y hora en que se creó el mensaje", example = "2024-11-13T11:34:33.111674")
    LocalDateTime createdAt,

    @Schema(description = "El número de 'me gusta' que tiene el mensaje", example = "3")
    Integer likes
) {
    public GratitudeMessageDTO(GratitudeMessage message) {
        this(message.getId(), message.getMessage(), message.getSenderName(), message.getCreatedAt(), message.getLikes());
    }
}
