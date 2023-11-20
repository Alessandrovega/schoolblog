package pe.edu.upc.schoolblog.evaluation.service;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.edu.upc.schoolblog.courses.domain.entity.Course;
import pe.edu.upc.schoolblog.evaluation.domain.model.entity.Evaluation;
import pe.edu.upc.schoolblog.evaluation.domain.persistence.EvaluationRepository;
import pe.edu.upc.schoolblog.shared.exception.ResourceNotFoundException;

import javax.xml.validation.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EvaluationServiceImplTest {
    @InjectMocks
    private EvaluationServiceImpl evaluationService = new EvaluationServiceImpl();

    @Mock
    private EvaluationRepository evaluationRepository;

    @Mock
    private Validator validator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFetchAll() {
        List<Evaluation> evaluations = new ArrayList<>();
        evaluations.add(new Evaluation());
        evaluations.add(new Evaluation());

        when(evaluationRepository.findAll()).thenReturn(evaluations);

        List<Evaluation> result = evaluationService.fetchAll();

        assertEquals(2, result.size());
    }

    @Test
    public void testFetchById() {
        Integer id = 1;
        Evaluation evaluation = new Evaluation();
        evaluation.setId(id);

        when(evaluationRepository.existsById(id)).thenReturn(true);
        when(evaluationRepository.findById(id)).thenReturn(Optional.of(evaluation));

        Optional<Evaluation> result = evaluationService.fetchById(id);

        assertTrue(result.isPresent());
        assertEquals(id, result.get().getId());
    }

    @Test
    public void testFetchByIdNotFound() {
        Integer id = 1;

        when(evaluationRepository.existsById(id)).thenReturn(false);


        assertThrows(ResourceNotFoundException.class, () -> evaluationService.fetchById(id));
    }


    @Test
    public void testFetchByCourse() {
        Course course = new Course();
        course.setId(1);

        List<Evaluation> evaluations = new ArrayList<>();
        evaluations.add(new Evaluation());
        evaluations.add(new Evaluation());

        when(evaluationRepository.findByCourse(course)).thenReturn(evaluations);


        List<Evaluation> result = evaluationService.fetchByCourse(course);

        assertEquals(2, result.size());
    }


    @Test
    public void testUpdate() {
        Evaluation evaluation = new Evaluation();
        evaluation.setId(1);

        when(evaluationRepository.save(evaluation)).thenReturn(evaluation);

        Evaluation updatedEvaluation = evaluationService.update(evaluation);

        assertNotNull(updatedEvaluation);
        assertEquals(1, updatedEvaluation.getId());
    }

    @Test
    public void testDeleteById() {
        Integer id = 1;

        when(evaluationRepository.existsById(id)).thenReturn(true);

        boolean result = evaluationService.deleteById(id);

        assertTrue(result);
        verify(evaluationRepository, times(1)).deleteById(id);
    }

    @Test
    public void testDeleteByIdNotFound() {
        Integer id = 1;

        when(evaluationRepository.existsById(id)).thenReturn(false);

        boolean result = evaluationService.deleteById(id);

        assertFalse(result);
        verify(evaluationRepository, never()).deleteById(id);
    }


}