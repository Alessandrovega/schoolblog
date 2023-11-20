package pe.edu.upc.schoolblog.courses.domain.service;

import pe.edu.upc.schoolblog.courses.domain.entity.Course;
import pe.edu.upc.schoolblog.teachers.domain.model.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> fetchAll();
    Optional<Course> fetchById(Integer id);
    Course save(Course course);
    Course update(Course course);
    boolean deleteById(Integer id);

    List<Course> fetchByTeacherId(Teacher teacher);
}
