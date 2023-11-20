package pe.edu.upc.schoolblog.shared.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.edu.upc.schoolblog.shared.mapping.EnhancedModelMapper;
import pe.edu.upc.schoolblog.student.mapping.StudentMapper;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {

    @Bean
    public EnhancedModelMapper modelMapper() {
        return new EnhancedModelMapper();
    }


}