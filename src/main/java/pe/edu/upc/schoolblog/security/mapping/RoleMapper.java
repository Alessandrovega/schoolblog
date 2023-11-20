package pe.edu.upc.schoolblog.security.mapping;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.schoolblog.security.domain.model.entity.Role;
import pe.edu.upc.schoolblog.security.domain.model.enumeration.Roles;
import pe.edu.upc.schoolblog.security.resource.RoleResource;
import pe.edu.upc.schoolblog.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class RoleMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    Converter<Roles, String> rolesToStringConverter = new AbstractConverter<Roles, String>() {
        @Override
        protected String convert(Roles roles) {
            return roles == null ? null : roles.name();
        }
    };

    // Object Mapping
    public RoleResource toResource(Role model) {
        mapper.addConverter(rolesToStringConverter);
        return mapper.map(model, RoleResource.class);
    }

    public Page<RoleResource> modelListToPage(List<Role> modelList, Pageable pageable) {
        mapper.addConverter(rolesToStringConverter);
        return new PageImpl<>(mapper.mapList(modelList, RoleResource.class), pageable, modelList.size());
    }

}