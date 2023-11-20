package pe.edu.upc.schoolblog.teachers.domain.service;

import pe.edu.upc.schoolblog.teachers.domain.model.entity.Teacher;

import java.util.List;

import java.util.Optional;

public interface TeacherService {

    List<Teacher> fetchAll();

    Optional<Teacher> fetchById(Integer id);

    Teacher save (Teacher teacher);

    Teacher update(Teacher teacher);

    boolean deleteById(Integer id);

}
