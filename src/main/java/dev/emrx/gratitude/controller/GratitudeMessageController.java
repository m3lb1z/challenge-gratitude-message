package dev.emrx.gratitude.controller;

import dev.emrx.gratitude.dto.CreateGratitudeMessageRequest;
import dev.emrx.gratitude.dto.GratitudeMessageDTO;
import dev.emrx.gratitude.model.GratitudeMessage;
import dev.emrx.gratitude.service.GratitudeMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gratitude")
public class GratitudeMessageController {

    @Autowired
    private GratitudeMessageService gratitudeMessageService;

    @PostMapping
    public ResponseEntity<GratitudeMessageDTO> createGratitudeMessage(@RequestBody CreateGratitudeMessageRequest request) {
        GratitudeMessage gratitudeMessage = new GratitudeMessage(request.message(), request.senderName());
        GratitudeMessage createdMessage = gratitudeMessageService.createGratitudeMessage(gratitudeMessage);
        return new ResponseEntity<>(new GratitudeMessageDTO(createdMessage), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GratitudeMessageDTO>> getAllGratitudeMessages(@RequestParam(required = false, defaultValue = "date") String sortBy) {
        List<GratitudeMessage> messages = gratitudeMessageService.getAllGratitudeMessages(sortBy);
        List<GratitudeMessageDTO> messagesResponse = messages.stream()
            .map(GratitudeMessageDTO::new)
            .toList();
        return ResponseEntity.ok(messagesResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGratitudeMessage(@PathVariable Long id) {
        gratitudeMessageService.deleteGratitudeMessage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}/like")
    public ResponseEntity<GratitudeMessageDTO> likeGratitudeMessage(@PathVariable Long id) {
        GratitudeMessage likedMessage = gratitudeMessageService.likeGratitudeMessage(id);
        return ResponseEntity.ok(new GratitudeMessageDTO(likedMessage));
    }
}
