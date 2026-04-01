package rogs.Axon.core.Service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import rogs.Axon.api.dto.NotaRequest;
import rogs.Axon.core.model.Link;
import rogs.Axon.core.model.Nota;
import rogs.Axon.core.ports.AISynthesisPort;
import rogs.Axon.core.ports.NotaRepositoryPort;
import rogs.Axon.infra.repositories.LinkRepository;

@Service
public class NoteService {

    private final NotaRepositoryPort noteRepository;
    private final AISynthesisPort aiSynthesisPort;

    public NoteService(NotaRepositoryPort noteRepository, AISynthesisPort aiSynthesisPort) {
        this.noteRepository = noteRepository;
        this.aiSynthesisPort = aiSynthesisPort;
    }

    @Transactional
    public Nota createNote(NotaRequest note) {

        Nota nota = new Nota(note.title(), note.content());
        Nota savedNote = noteRepository.save(nota);
        return savedNote;

    }

    public Nota getNoteWithConnections(UUID id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota não encontrada"));
    }
}