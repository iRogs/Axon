package rogs.Axon.api.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record NotaResponse(
    UUID id,
    String title,
    String content,
    LocalDateTime createdAt
) {}