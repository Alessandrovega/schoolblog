package pe.edu.upc.schoolblog.courses.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.schoolblog.courses.domain.entity.Course;
import pe.edu.upc.schoolblog.teachers.domain.model.entity.Teacher;

import java.util.List;
import java.util.Optional;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>  {
    Optional<Course> findByName(String name);
    List<Course> findByLevel(String level);
    List<Course> findByLevelAndGrade(String level, String grade);
    List<Course> findByLevelAndGradeAndSection(String level, String grade, String section);

    Optional<Course> findByNameAndLevelAndAndGradeAndAndSection(String name, String level, String grade, String section);

    List<Course> findByTeacher(Teacher teacher);

}
