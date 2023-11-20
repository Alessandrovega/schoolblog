package pe.edu.upc.schoolblog.courses.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.schoolblog.evaluation.domain.model.entity.Evaluation;
import pe.edu.upc.schoolblog.student.domain.model.entity.Student;
import pe.edu.upc.schoolblog.teachers.domain.model.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 2, max = 50)
    @NotBlank
    @Column(name = "name", length = 2, nullable = false)
    private String name;

    @NotNull
    @Size(min = 2, max = 200)
    @NotBlank
    @Column(name = "description", length = 2, nullable = false)
    private String description;

    @NotNull
    @NotBlank
    @Column(name = "level", nullable = false)
    private String level;

    @NotNull
    @NotBlank
    @Column(name = "grade", nullable = false)
    private String grade;

    @NotNull
    @NotBlank
    @Column(name = "section", nullable = false)
    private String section;

    @JsonIgnore
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    @JsonIgnore
    @NotNull
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<Evaluation> evaluations;

}
