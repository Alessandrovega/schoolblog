package pe.edu.upc.schoolblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
@SpringBootApplication
@OpenAPIDefinition
public class SchoolblogApplication {

  public static void main(String[] args) {

    SpringApplication.run(SchoolblogApplication.class, args);
  }
}
