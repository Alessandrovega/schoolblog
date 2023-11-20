package pe.edu.upc.schoolblog.evaluation.domain.service;

import pe.edu.upc.schoolblog.courses.domain.entity.Course;
import pe.edu.upc.schoolblog.evaluation.domain.model.entity.Evaluation;

import java.util.List;
import java.util.Optional;

public interface EvaluationService {
    List<Evaluation> fetchAll();    // getAll, fetchAll, getEvaluations
    Optional<Evaluation> fetchById(Integer id);

    List<Evaluation> fetchByCourse(Course course);
    Evaluation save(Evaluation Evaluation);
    Evaluation update(Evaluation Evaluation);
    boolean deleteById(Integer id);

}
