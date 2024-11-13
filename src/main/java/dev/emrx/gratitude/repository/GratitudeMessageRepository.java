package dev.emrx.gratitude.repository;

import dev.emrx.gratitude.model.GratitudeMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GratitudeMessageRepository extends JpaRepository<GratitudeMessage, Long> {
    List<GratitudeMessage> findAllByOrderByLikesDesc();
    List<GratitudeMessage> findAllByOrderByCreatedAtDesc();
}
