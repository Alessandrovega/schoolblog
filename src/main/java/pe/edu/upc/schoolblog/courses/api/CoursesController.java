package pe.edu.upc.schoolblog.courses.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.schoolblog.courses.domain.entity.Course;
import pe.edu.upc.schoolblog.courses.domain.service.CourseService;
import pe.edu.upc.schoolblog.courses.mapping.CourseMapper;
import pe.edu.upc.schoolblog.courses.resource.CourseResource;
import pe.edu.upc.schoolblog.courses.resource.CreateCourseResource;
import pe.edu.upc.schoolblog.courses.resource.UpdateCourseResource;
import pe.edu.upc.schoolblog.shared.Constant;
import pe.edu.upc.schoolblog.shared.exception.ResourceNotFoundException;
import pe.edu.upc.schoolblog.teachers.domain.model.entity.Teacher;
import pe.edu.upc.schoolblog.teachers.domain.persistence.TeacherRepository;
import pe.edu.upc.schoolblog.teachers.domain.service.TeacherService;

import java.util.List;
import java.util.Optional;

@Tag(name= "Courses", description = "Create, Read, Update and Delete courses entities")
@RestController
@RequestMapping("courses")
@AllArgsConstructor
public class CoursesController {
    private final CourseService courseService;
    private final TeacherService teacherService;
    private final CourseMapper mapper;


    @Operation(summary = "Save A Course", responses = {
            @ApiResponse(description = "Course successfully created",
            responseCode = "201", content =
            @Content(mediaType = "application/json",
            schema = @Schema(implementation = CourseResource.class)))
    })
    @PostMapping
    public ResponseEntity<CourseResource> save(@RequestBody CreateCourseResource resource) {

        Optional<Teacher> teacher = teacherService.fetchById(resource.getTeacher_id());

        if (teacher == null){
            return ResponseEntity.badRequest().body(null);
        }

       Course newCourse = mapper.toModel(resource);
        newCourse.setTeacher(teacher.get());

        teacher.get().getCourses().add(newCourse);

        return new ResponseEntity<>(
                mapper.toResource(courseService.save(newCourse)),
                HttpStatus.CREATED);
    }

    @GetMapping
    public List<Course> fetchAll() {
        return courseService.fetchAll();
    }


    @Operation(summary = "Find by CourseId", responses = {
            @ApiResponse(description = "Course successfully found",
            responseCode = "200",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = CourseResource.class)) )
    })
    @GetMapping("{id}")
    public ResponseEntity<CourseResource> fetchId(@PathVariable Integer id) {
        return new ResponseEntity<>(
                this.mapper.toResource(courseService.fetchById(id).get()),
                HttpStatus.OK);
    }

    @GetMapping("/teacher/{teacher_id}")
    public List<Course> fetchByTeacherId(@PathVariable Integer teacher_id){
        Optional<Teacher> teacher = teacherService.fetchById(teacher_id);

        if (!teacher.isEmpty())
            return courseService.fetchByTeacherId(teacher.get());
        else{
            throw new ResourceNotFoundException(Constant.TEACHER_ENTITY, teacher_id);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<CourseResource> update(@PathVariable Integer id,
                                                 @RequestBody UpdateCourseResource resource) {
        if (id.equals(resource.getId())) {
            CourseResource courseResource = (mapper.toResource(
                    courseService.update(mapper.toModel(resource))));
            return new ResponseEntity<>(courseResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (courseService.deleteById(id)) {
            return ResponseEntity.ok().build(); // Devolver de forma directa - lambda
            //return new ResponseEntity<>(HttpStatus.OK); // Devolución con instanciación
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
