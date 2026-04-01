package rogs.Axon.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rogs.Axon.api.dto.NotaRequest;
import rogs.Axon.api.dto.NotaResponse;
import rogs.Axon.core.Service.NoteService;
import rogs.Axon.core.model.Nota;

@RestController
@RequestMapping("/api/v1/notas")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<NotaResponse> create(@RequestBody NotaRequest request) {
        
        Nota saved = noteService.createNote(request);
        
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(new NotaResponse(saved.getId(), saved.getTitle(), 
                                                   saved.getContent(), saved.getCreatedAt()));
    }
}
