package pe.edu.upc.schoolblog.evaluation.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("evaluationMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public EvaluationMapper evaluationMapper() {
        return new EvaluationMapper();
    }
}
