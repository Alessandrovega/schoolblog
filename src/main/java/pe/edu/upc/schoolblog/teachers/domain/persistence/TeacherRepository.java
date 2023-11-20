package pe.edu.upc.schoolblog.teachers.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.schoolblog.teachers.domain.model.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
