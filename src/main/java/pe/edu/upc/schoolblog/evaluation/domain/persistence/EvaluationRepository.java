package pe.edu.upc.schoolblog.evaluation.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.schoolblog.courses.domain.entity.Course;
import pe.edu.upc.schoolblog.evaluation.domain.model.entity.Evaluation;

import java.util.List;
import java.util.Optional;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Integer> {

    List<Evaluation> findByCourse(Course course);

}







