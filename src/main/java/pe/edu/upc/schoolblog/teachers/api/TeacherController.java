package pe.edu.upc.schoolblog.teachers.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import pe.edu.upc.schoolblog.teachers.domain.model.entity.Teacher;

import pe.edu.upc.schoolblog.teachers.domain.service.TeacherService;

import pe.edu.upc.schoolblog.teachers.mapping.TeacherMapper;

import pe.edu.upc.schoolblog.teachers.resource.CreateTeacherResource;

import pe.edu.upc.schoolblog.teachers.resource.TeacherResource;

import pe.edu.upc.schoolblog.teachers.resource.UpdateTeacherResource;

import java.util.List;

@Tag(name = "Teachers", description = "Create, Read, Update and Delete teachers entities")
@RestController
@RequestMapping("teachers")
@AllArgsConstructor

public class TeacherController {
    private final TeacherService teacherService;
    private final TeacherMapper mapper;

    @Operation(summary = "Save the teacher", responses = {
            @ApiResponse(description = "Teacher successfully created",
            responseCode = "201",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = TeacherResource.class)))
    })
    @PostMapping
    public TeacherResource save(@RequestBody CreateTeacherResource resource) {
        return mapper.toResource(teacherService.save(mapper.toModel(resource)));
    }

    @GetMapping
    public List<Teacher> fetchAll() {
        return teacherService.fetchAll();
    }


    @Operation(summary = "Find by id of the teacher", responses = {
            @ApiResponse(description = "Teacher successfully found",
            responseCode = "200",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = TeacherResource.class)))
    })
    @GetMapping("{id}")
    public TeacherResource fetchId(@PathVariable Integer id) {
        return this.mapper.toResource(teacherService.fetchById(id).get());
    }

    @PutMapping("{id}")
    public ResponseEntity<TeacherResource> update(@PathVariable Integer id,
                                                  @RequestBody UpdateTeacherResource resource) {
        if (id.equals(resource.getId())) {
            TeacherResource teacherResource = (mapper.toResource(teacherService.update(mapper.toModel(resource))));//convert resource to model
            return new ResponseEntity<>(teacherResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (teacherService.deleteById(id)) {
            return ResponseEntity.ok().build(); // Devolver de forma directa - lambda
            //return new ResponseEntity<>(HttpStatus.OK); // Devolución con instanciación
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
