package rogs.Axon.core.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;

@Entity
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private Nota sourceNote;

    @ManyToOne
    @JoinColumn(name = "target_id")
    private Nota targetNote;

    private String relationType; // ex: "references", "contradicts", "summarizes"
}
