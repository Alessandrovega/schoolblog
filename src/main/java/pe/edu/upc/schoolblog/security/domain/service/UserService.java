package pe.edu.upc.schoolblog.security.domain.service;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import pe.edu.upc.schoolblog.security.domain.model.entity.User;
import pe.edu.upc.schoolblog.security.domain.service.communication.AuthenticateRequest;
import pe.edu.upc.schoolblog.security.domain.service.communication.RegisterRequest;

import java.util.List;


public interface UserService extends UserDetailsService {
    ResponseEntity<?> authentication(AuthenticateRequest request);
    ResponseEntity<?>  register(RegisterRequest request);
    List<User> getAll();
}