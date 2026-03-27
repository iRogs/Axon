package rogs.Axon.core.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "notes")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    // Para o Agente de Síntese: Guardamos o vetor do conteúdo
    @Column(columnDefinition = "vector(1536)") // Tamanho padrão OpenAI
    private double[] embedding;

    @OneToMany(mappedBy = "sourceNote", cascade = CascadeType.ALL)
    private Set<Link> links = new HashSet<>();
}
