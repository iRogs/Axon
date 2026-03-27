package rogs.Axon.core.model.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rogs.Axon.core.model.Link;
import rogs.Axon.infra.repositories.LinkRepository;

@Service
public class LinkService {
    @Autowired
    private LinkRepository linkRepository;

    public Link save(Link link) {
        return linkRepository.save(link);
    }

    public java.util.List<Link> findAll() {
        return linkRepository.findAll();
    }

    public java.util.Optional<Link> findById(Long id) {
        return linkRepository.findById(id);
    }

    public void deleteById(Long id) {
        linkRepository.deleteById(id);
    }

}
