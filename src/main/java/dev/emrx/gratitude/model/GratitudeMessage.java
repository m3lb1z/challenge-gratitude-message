package dev.emrx.gratitude.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GratitudeMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String message;

    @Column(name = "sender_name", nullable = false)
    private String senderName;

    @CreatedDate
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private int likes;

    public GratitudeMessage(String message, String senderName) {
        this.message = message;
        this.senderName = senderName;
        this.likes = 0;
    }

    public GratitudeMessage(String message, String senderName, int likes) {
        this.message = message;
        this.senderName = senderName;
        this.likes = likes;
    }
}
