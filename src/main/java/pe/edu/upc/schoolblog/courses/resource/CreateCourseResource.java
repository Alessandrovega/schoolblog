package pe.edu.upc.schoolblog.courses.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import pe.edu.upc.schoolblog.evaluation.domain.model.entity.Evaluation;
import pe.edu.upc.schoolblog.student.domain.model.entity.Student;
import pe.edu.upc.schoolblog.teachers.domain.model.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseResource {
    @NotNull
    @NotBlank
    @Size(max = 50)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String description;

    @NotNull
    @NotBlank
    private String level;

    @NotNull
    @NotBlank
    private String grade;

    @NotNull
    @NotBlank
    private String section;

    @NotNull
    private Integer teacher_id;

}
