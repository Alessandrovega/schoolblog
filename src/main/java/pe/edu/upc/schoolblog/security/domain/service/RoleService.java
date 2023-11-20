package pe.edu.upc.schoolblog.security.domain.service;

import pe.edu.upc.schoolblog.security.domain.model.entity.Role;

import java.util.List;

public interface RoleService {

    void seed();
    List<Role> getAll();

}
