package rogs.Axon.api.dto;

import java.util.Set;
import java.util.UUID;

public record NotaRequest(
    String title,
    String content,
    Set<UUID> linkedNoteIds 
    ) {}
