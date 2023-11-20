package pe.edu.upc.schoolblog.principals.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("principalMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public PrincipalMapper principalMapper(){
        return new PrincipalMapper();
    }
}
