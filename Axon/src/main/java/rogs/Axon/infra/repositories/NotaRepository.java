package rogs.Axon.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rogs.Axon.core.model.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {
    
}
