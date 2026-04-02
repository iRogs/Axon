package rogs.Axon.infra.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import rogs.Axon.core.model.Usuario;

public interface UserRepository extends JpaRepository<Usuario, UUID>{
    
}
