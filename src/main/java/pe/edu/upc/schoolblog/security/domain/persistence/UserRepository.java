package pe.edu.upc.schoolblog.security.domain.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.schoolblog.security.domain.model.entity.User;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

}