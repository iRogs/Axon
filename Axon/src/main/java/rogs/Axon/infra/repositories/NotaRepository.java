package rogs.Axon.infra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rogs.Axon.core.model.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {
    
    @Query(value = "SELECT * FROM notes ORDER BY embedding <=> CAST(:embedding AS vector) LIMIT :limit", 
           nativeQuery = true)
    List<Nota> findSimilarNotes(@Param("embedding") double[] embedding, @Param("limit") int limit);
}
