package pe.edu.upc.schoolblog.principals.domain.service;

import pe.edu.upc.schoolblog.principals.domain.entity.Principal;

import java.util.List;
import java.util.Optional;

public interface PrincipalService {
    List<Principal> fetchAll();
    Optional<Principal> fetchById(Integer id);
    Principal save(Principal principal);
    Principal update(Principal principal);
    boolean deleteById(Integer id);
}
