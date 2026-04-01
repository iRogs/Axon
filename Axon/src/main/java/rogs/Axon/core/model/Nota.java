package rogs.Axon.core.model;

import java.time.LocalDateTime;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

@Entity
@Table(name = "notes")
@Getter @Setter
@NoArgsConstructor
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    
    //Guardamos o vetor do conteúdo para o Agente 
    @Column(columnDefinition = "vector(1536)") // Tamanho padrão OpenAI
    private double[] embedding;

    @OneToMany(mappedBy = "sourceNote", cascade = CascadeType.ALL)
    private Set<Link> links = new HashSet<>();

    public Nota(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
