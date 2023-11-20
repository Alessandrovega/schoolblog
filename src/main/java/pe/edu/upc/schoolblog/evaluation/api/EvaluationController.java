package pe.edu.upc.schoolblog.evaluation.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.schoolblog.courses.domain.entity.Course;
import pe.edu.upc.schoolblog.courses.domain.service.CourseService;
import pe.edu.upc.schoolblog.evaluation.domain.model.entity.Evaluation;
import pe.edu.upc.schoolblog.evaluation.domain.service.EvaluationService;
import pe.edu.upc.schoolblog.evaluation.mapping.EvaluationMapper;
import pe.edu.upc.schoolblog.evaluation.resource.CreateEvaluationResource;
import pe.edu.upc.schoolblog.evaluation.resource.EvaluationResource;
import pe.edu.upc.schoolblog.evaluation.resource.UpdateEvaluationResource;
import pe.edu.upc.schoolblog.shared.Constant;
import pe.edu.upc.schoolblog.shared.exception.ResourceNotFoundException;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Tag(name = "Evaluations", description = "Create, Read, Update and Delete Evaluations entities")
@RestController
@RequestMapping("evaluations")
@AllArgsConstructor
public class EvaluationController {
    private final EvaluationService evaluationService;
    private final CourseService courseService;
    private final EvaluationMapper mapper;


    @Operation(summary = "Save the evaluation", responses = {
            @ApiResponse(description = "Evaluation successfully created",
            responseCode = "201",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = EvaluationResource.class)))
    })

    @PostMapping
    public EvaluationResource save(@RequestBody CreateEvaluationResource resource) {

        Evaluation newEvaluation = mapper.toModel(resource);

        Optional<Course> course = courseService.fetchById(resource.getCourse_id());

        if (course.isEmpty()){
            throw new ResourceNotFoundException(Constant.COURSE_ENTITY, resource.getCourse_id());
        }

        newEvaluation.setCourse(course.get());

        return mapper.toResource( evaluationService.save( newEvaluation) ) ;
    }

    @GetMapping
    public List<Evaluation> fetchAll() {
        return evaluationService.fetchAll();
    }


    @Operation(summary = "Find by EvaluationId", responses = {
        @ApiResponse(description = "Evaluation succesfully found",
        responseCode = "200",
        content = @Content(mediaType = "application/json",
        schema = @Schema(implementation = EvaluationResource.class)))
    })
    @GetMapping("{id}")
    public EvaluationResource fetchId(@PathVariable Integer id) {
        return this.mapper.toResource(evaluationService.fetchById(id).get());
    }

    @GetMapping("/courses/{course_id}")
    public List<Evaluation> fetchByCourseId(@PathVariable Integer course_id){
        Optional<Course> course = courseService.fetchById(course_id);
        if (course.isEmpty()){
            throw new ResourceNotFoundException(Constant.COURSE_ENTITY, course_id);
        }

        return evaluationService.fetchByCourse(course.get());
    }

    @PutMapping("{id}")
    public ResponseEntity<EvaluationResource> update(@PathVariable Integer id,
                                                     @RequestBody UpdateEvaluationResource resource) {
        if (id.equals(resource.getId())) {

            Evaluation evaluation = mapper.toModel(resource);

            Optional<Course> course = courseService.fetchById(resource.getCourse_id());
            evaluation.setCourse(course.get());

            EvaluationResource EvaluationResource = mapper.toResource(
                    evaluationService.update( evaluation) );
            return new ResponseEntity<>(EvaluationResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (evaluationService.deleteById(id)) {
            return ResponseEntity.ok().build(); // Devolver de forma directa - lambda
            //return new ResponseEntity<>(HttpStatus.OK); // Devolución con instanciación
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}




