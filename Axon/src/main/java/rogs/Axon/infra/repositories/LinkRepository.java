package rogs.Axon.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rogs.Axon.core.model.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
