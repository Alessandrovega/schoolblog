package pe.edu.upc.schoolblog.principals.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.schoolblog.principals.domain.entity.Principal;
import pe.edu.upc.schoolblog.principals.domain.persistence.PrincipalRepository;
import pe.edu.upc.schoolblog.principals.domain.service.PrincipalService;
import pe.edu.upc.schoolblog.shared.Constant;
import pe.edu.upc.schoolblog.shared.exception.ResourceNotFoundException;
import pe.edu.upc.schoolblog.shared.exception.ResourceValidationException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PrincipalServiceImpl implements PrincipalService {

    @Autowired
    private PrincipalRepository principalRepository;

    @Autowired
    private Validator validator;

    @Transactional(readOnly = true)
    @Override
    public List<Principal> fetchAll() {
        return principalRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Principal> fetchById(Integer id) {

        if (principalRepository.existsById(id)){
            return principalRepository.findById(id);
        }
        else{
            throw new ResourceNotFoundException(Constant.PRINCIPAL_ENTITY, id);
        }
    }

    @Transactional
    @Override
    public Principal save(Principal principal) {
        Set<ConstraintViolation<Principal>> violations =
                validator.validate(principal);

        if (!violations.isEmpty()){
            throw new ResourceValidationException(violations);
        }

        return principalRepository.save(principal);
    }

    @Transactional
    @Override
    public Principal update(Principal principal) {
        return principalRepository.save(principal);
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        if (principalRepository.existsById(id)){
            principalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
