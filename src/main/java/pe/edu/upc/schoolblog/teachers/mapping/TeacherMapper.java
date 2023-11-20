package pe.edu.upc.schoolblog.teachers.mapping;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.upc.schoolblog.shared.mapping.EnhancedModelMapper;

import pe.edu.upc.schoolblog.teachers.domain.model.entity.Teacher;

import pe.edu.upc.schoolblog.teachers.resource.CreateTeacherResource;

import pe.edu.upc.schoolblog.teachers.resource.TeacherResource;

import pe.edu.upc.schoolblog.teachers.resource.UpdateTeacherResource;

import java.io.Serializable;

public class TeacherMapper implements Serializable {
    @Autowired
   EnhancedModelMapper mapper;

    public Teacher toModel(CreateTeacherResource resource) {

        return this.mapper.map(resource, Teacher.class);

    }

    public Teacher toModel(UpdateTeacherResource resource){

        return this.mapper.map(resource, Teacher.class);

    }

    public TeacherResource toResource(Teacher teacher) {

        return this.mapper.map(teacher, TeacherResource.class);

    }

}
