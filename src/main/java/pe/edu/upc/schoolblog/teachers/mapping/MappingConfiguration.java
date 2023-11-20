package pe.edu.upc.schoolblog.teachers.mapping;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

@Configuration("teachersMappingConfiguration")

public class MappingConfiguration {

    @Bean

    public TeacherMapper teacherMapper() {

        return new TeacherMapper();

    }

}
