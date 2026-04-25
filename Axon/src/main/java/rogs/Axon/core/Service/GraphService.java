package rogs.Axon.core.Service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.transaction.Transactional;
import rogs.Axon.core.model.Nota;
import rogs.Axon.core.model.NotaLink;
import rogs.Axon.core.model.Usuario;
import rogs.Axon.core.ports.GraphRepositoryPort;
import rogs.Axon.core.ports.NotaRepositoryPort;


public class GraphService {
    @Autowired
    private GraphRepositoryPort graphRepository;
    @Autowired
    private final NotaRepositoryPort notaRepository;

    @Transactional
    public void connectNotes(UUID fromId, UUID toId, String relation_type, Usuario user){
        if(fromId.equals(toId)){
            throw new IllegalArgumentException("Uma nota não pode se conectar a ela mesma");
        }

        if(!graphRepository.existsByFromTo(fromId, toId)){
            Nota from = notaRepository.findById(fromId);
            Nota to = notaRepository.findById(toId);

            NotaLink link =  new NotaLink();
            link.setNota_From(from);;
            link.setNota_To(to);
            link.setUser(user);

            graphRepository.save(link);
        }
    }

}
