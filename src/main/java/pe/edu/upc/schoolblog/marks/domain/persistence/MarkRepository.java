package pe.edu.upc.schoolblog.marks.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.schoolblog.evaluation.domain.model.entity.Evaluation;
import pe.edu.upc.schoolblog.marks.domain.entity.Mark;
import pe.edu.upc.schoolblog.student.domain.model.entity.Student;

import java.util.List;
import java.util.Optional;

public interface MarkRepository extends JpaRepository<Mark, Integer> {
    List<Mark> findByStudentId(Integer studentId);

    List<Mark> findByTeacherId(Integer teacherId);

    Optional<Mark> findByEvaluationId(Integer evaluationId);

    List<Mark> findByStudent(Student student);

    List<Mark> findByEvaluation(Evaluation evaluation);


    Optional<Mark> findById(Integer id);

}
