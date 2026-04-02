package rogs.Axon.core.Service;

import org.springframework.security.crypto.password4j.BcryptPassword4jPasswordEncoder;

import rogs.Axon.api.dto.UserRegistrationRequest;
import rogs.Axon.core.model.Usuario;
import rogs.Axon.infra.repositories.UserRepository;

public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(UserRegistrationRequest request) {
        Usuario user = new Usuario();
        user.setEmail(request.email());
        BcryptPassword4jPasswordEncoder encoder = new BcryptPassword4jPasswordEncoder();
        user.setPassword(encoder.encode(request.password()));
        userRepository.save(user);
    }

}
