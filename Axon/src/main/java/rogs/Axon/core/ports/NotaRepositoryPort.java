package rogs.Axon.core.ports;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import rogs.Axon.core.model.Nota;

public interface NotaRepositoryPort {
    Nota save(Nota note);
    Optional<Nota> findById(UUID id);
    List<Nota> findBySimilarity(double[] embedding, int limit);
}
