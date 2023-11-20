package pe.edu.upc.schoolblog.marks.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.schoolblog.evaluation.domain.model.entity.Evaluation;
import pe.edu.upc.schoolblog.evaluation.domain.service.EvaluationService;
import pe.edu.upc.schoolblog.marks.domain.entity.Mark;
import pe.edu.upc.schoolblog.marks.domain.service.MarkService;
import pe.edu.upc.schoolblog.marks.mapping.MarkMapper;
import pe.edu.upc.schoolblog.marks.resource.CreateMarkResource;
import pe.edu.upc.schoolblog.marks.resource.MarkResource;
import pe.edu.upc.schoolblog.marks.resource.UpdateMarkResource;
import pe.edu.upc.schoolblog.shared.Constant;
import pe.edu.upc.schoolblog.shared.exception.ResourceNotFoundException;
import pe.edu.upc.schoolblog.student.domain.model.entity.Student;
import pe.edu.upc.schoolblog.student.domain.service.StudentService;

import java.util.List;
import java.util.Optional;

@Tag(name = "Marks", description = "Create, Read, Update and Delete MARKS entities")
@RestController
@RequestMapping("marks")
@AllArgsConstructor
public class MarkController {

    private final MarkService markService;
    private final StudentService studentService;
    private final EvaluationService evaluationService;
    private final MarkMapper mapper;

    @GetMapping
    public List<Mark> fetchAll(){
        return markService.fetchAll();
    }


    @Operation(summary = "Find by MarkId", responses = {
            @ApiResponse(description = "Mark successfully found",
            responseCode = "200",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = MarkResource.class)))
    })
    @GetMapping("{id}")
    public MarkResource fetchId(@PathVariable Integer id) {
        return this.mapper.toResource(markService.fetchById(id).get());
    }

    @GetMapping("/students/{student_id}")
    public List<Mark> fetchCourseId(@PathVariable Integer student_id){
        Optional<Student> student = studentService.fetchById(student_id);

        if (student.isEmpty()){
            throw new ResourceNotFoundException(Constant.STUDENT_ENTITY, student_id);
        }

        return markService.fetchByStudent(student.get());
    }

    @Operation(summary = "Save a mark", responses = {
            @ApiResponse(description = "Mark successfully created",
            responseCode = "201",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = MarkResource.class)))
    })
    @PostMapping
    public MarkResource save(@RequestBody CreateMarkResource resource) {

        Optional<Evaluation> evaluation = evaluationService.fetchById(resource.getEvaluation_id());

        if (evaluation.isEmpty()){
            throw new ResourceNotFoundException(Constant.EVALUATION_ENTITY, resource.getEvaluation_id());
        }

        Optional<Student> student = studentService.fetchById(resource.getStudentId());

        if (student.isEmpty()) {
            throw new ResourceNotFoundException(Constant.STUDENT_ENTITY, resource.getStudentId());
        }

        Mark newMark = mapper.toModel(resource);
        newMark.setEvaluation(evaluation.get());
        newMark.setStudent(student.get());

        return mapper.toResource(markService.save(newMark));
    }

    @PutMapping("{id}")
    public ResponseEntity<MarkResource> update(@PathVariable Integer id,
                                               @RequestBody UpdateMarkResource resource) {

        if (id.equals(resource.getId())) {

            Mark newMark = mapper.toModel(resource);

            Optional<Student> student = studentService.fetchById(resource.getStudentId());

            Optional<Evaluation> evaluation = evaluationService.fetchById(resource.getEvaluationId());

            newMark.setStudent(student.get());
            newMark.setEvaluation(evaluation.get());

            MarkResource markResource = mapper.toResource(
                    markService.update( newMark) );
            return new ResponseEntity<>(markResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (markService.deleteById(id)) {
            return ResponseEntity.ok().build(); // Devolver de forma directa - lambda
            //return new ResponseEntity<>(HttpStatus.OK); // Devolución con instanciación
        } else {
            return ResponseEntity.notFound().build();
        }
    }





}
