package pe.edu.upc.schoolblog.security.mapping;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.schoolblog.security.domain.model.entity.Role;
import pe.edu.upc.schoolblog.security.domain.model.entity.User;
import pe.edu.upc.schoolblog.security.resource.UserResource;
import pe.edu.upc.schoolblog.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    Converter<Role, String> roleToStringConverter = new AbstractConverter<Role, String>() {
        @Override
        protected String convert(Role role) {
            return role == null ? null : role.getName().name();
        }
    };

    // Object Mapping

    public UserResource toResource(User model) {
        mapper.addConverter(roleToStringConverter);
        return mapper.map(model, UserResource.class);
    }

    public Page<UserResource> modelListToPage(List<User> modelList, Pageable pageable) {
        mapper.addConverter(roleToStringConverter);
        return new PageImpl<>(mapper.mapList(modelList, UserResource.class), pageable, modelList.size());
    }

}
