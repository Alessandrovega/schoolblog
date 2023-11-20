package pe.edu.upc.schoolblog.principals.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.schoolblog.principals.domain.entity.Principal;
import pe.edu.upc.schoolblog.principals.resource.CreatePrincipalResource;
import pe.edu.upc.schoolblog.principals.resource.PrincipalResource;
import pe.edu.upc.schoolblog.principals.resource.UpdatePrincipalResource;
import pe.edu.upc.schoolblog.shared.mapping.EnhancedModelMapper;
import pe.edu.upc.schoolblog.student.domain.model.entity.Student;

import java.io.Serializable;

public class PrincipalMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public Principal toModel(CreatePrincipalResource resource) {
        return this.mapper.map(resource, Principal.class);
    }
    public Principal toModel(UpdatePrincipalResource resource) {
        return this.mapper.map(resource, Principal.class);
    }

    public PrincipalResource toResource(Principal principal) {
        return this.mapper.map(principal, PrincipalResource.class);
    }

}
