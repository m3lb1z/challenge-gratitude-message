package dev.emrx.gratitude.dto;

import java.time.LocalDateTime;
import dev.emrx.gratitude.model.GratitudeMessage;

public record GratitudeMessageDTO(
    Long id,
    String message,
    String senderName,
    LocalDateTime createdAt,
    Integer likes
) {
    public GratitudeMessageDTO(GratitudeMessage message) {
        this(message.getId(), message.getMessage(), message.getSenderName(), message.getCreatedAt(), message.getLikes());
    }
}
