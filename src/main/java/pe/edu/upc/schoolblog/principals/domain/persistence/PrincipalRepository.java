package pe.edu.upc.schoolblog.principals.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.schoolblog.principals.domain.entity.Principal;

@Repository
public interface PrincipalRepository extends JpaRepository<Principal, Integer> {
}
