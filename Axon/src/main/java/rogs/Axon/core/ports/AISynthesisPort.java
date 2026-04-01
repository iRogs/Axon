package rogs.Axon.core.ports;

import java.util.UUID;

public interface AISynthesisPort {
    void triggerAnalysis(UUID noteId);
}
