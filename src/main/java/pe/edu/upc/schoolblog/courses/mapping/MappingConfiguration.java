package pe.edu.upc.schoolblog.courses.mapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.edu.upc.schoolblog.marks.mapping.MarkMapper;

@Configuration("schoolblogMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public MarkMapper markMapper() {
        return new MarkMapper();
    }

    @Bean
    public CourseMapper courseMapper() {
        return new CourseMapper();
    }
}