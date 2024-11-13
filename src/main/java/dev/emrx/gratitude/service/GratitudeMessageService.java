package dev.emrx.gratitude.service;

import dev.emrx.gratitude.model.GratitudeMessage;
import dev.emrx.gratitude.repository.GratitudeMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GratitudeMessageService {

    @Autowired
    private GratitudeMessageRepository gratitudeMessageRepository;

    public GratitudeMessage createGratitudeMessage(GratitudeMessage gratitudeMessage) {
        return gratitudeMessageRepository.save(gratitudeMessage);
    }

    public List<GratitudeMessage> getAllGratitudeMessages(String sortBy) {
        if ("popularity".equalsIgnoreCase(sortBy)) {
            return gratitudeMessageRepository.findAllByOrderByLikesDesc();
        }
        return gratitudeMessageRepository.findAllByOrderByCreatedAtDesc();
    }

    public void deleteGratitudeMessage(Long id) {
        gratitudeMessageRepository.deleteById(id);
    }

    public GratitudeMessage likeGratitudeMessage(Long id) {
        Optional<GratitudeMessage> optionalMessage = gratitudeMessageRepository.findById(id);
        if (optionalMessage.isPresent()) {
            GratitudeMessage message = optionalMessage.get();
            message.setLikes(message.getLikes() + 1);
            return gratitudeMessageRepository.save(message);
        }
        throw new RuntimeException("Message not found with id: " + id);
    }
}
