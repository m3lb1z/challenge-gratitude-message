package dev.emrx.gratitude.controller;

import dev.emrx.gratitude.dto.CreateGratitudeMessageRequest;
import dev.emrx.gratitude.dto.GratitudeMessageDTO;
import dev.emrx.gratitude.model.GratitudeMessage;
import dev.emrx.gratitude.service.GratitudeMessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Crear un mensaje de agradecimiento", description = "Crea un nuevo mensaje de agradecimiento")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Mensaje de agradecimiento creado"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping
    public ResponseEntity<GratitudeMessageDTO> createGratitudeMessage(
        @RequestBody @Parameter(description = "Solicitud para crear un mensaje de agradecimiento") CreateGratitudeMessageRequest request) {
        GratitudeMessage gratitudeMessage = new GratitudeMessage(request.message(), request.senderName());
        GratitudeMessage createdMessage = gratitudeMessageService.createGratitudeMessage(gratitudeMessage);
        return new ResponseEntity<>(new GratitudeMessageDTO(createdMessage), HttpStatus.CREATED);
    }

    @Operation(summary = "Obtener todos los mensajes de agradecimiento", description = "Devuelve una lista de todos los mensajes de agradecimiento")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de mensajes de agradecimiento obtenida")
    })
    @GetMapping
    public ResponseEntity<List<GratitudeMessageDTO>> getAllGratitudeMessages(
        @RequestParam(required = false, defaultValue = "date") @Parameter(description = "Criterio de ordenación") String sortBy) {
        List<GratitudeMessage> messages = gratitudeMessageService.getAllGratitudeMessages(sortBy);
        List<GratitudeMessageDTO> messagesResponse = messages.stream()
            .map(GratitudeMessageDTO::new)
            .toList();
        return ResponseEntity.ok(messagesResponse);
    }

    @Operation(summary = "Eliminar un mensaje de agradecimiento", description = "Elimina un mensaje de agradecimiento por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Mensaje de agradecimiento eliminado"),
        @ApiResponse(responseCode = "404", description = "Mensaje de agradecimiento no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGratitudeMessage(
        @PathVariable @Parameter(description = "ID del mensaje de agradecimiento") Long id) {
        gratitudeMessageService.deleteGratitudeMessage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Dar me gusta a un mensaje de agradecimiento", description = "Incrementa el contador de me gusta de un mensaje de agradecimiento por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Mensaje de agradecimiento actualizado con un me gusta"),
        @ApiResponse(responseCode = "404", description = "Mensaje de agradecimiento no encontrado")
    })
    @PostMapping("/{id}/like")
    public ResponseEntity<GratitudeMessageDTO> likeGratitudeMessage(
        @PathVariable @Parameter(description = "ID del mensaje de agradecimiento") Long id) {
        GratitudeMessage likedMessage = gratitudeMessageService.likeGratitudeMessage(id);
        return ResponseEntity.ok(new GratitudeMessageDTO(likedMessage));
    }
}
