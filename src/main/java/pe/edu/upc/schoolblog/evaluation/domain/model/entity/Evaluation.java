package pe.edu.upc.schoolblog.evaluation.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pe.edu.upc.schoolblog.courses.domain.entity.Course;
import pe.edu.upc.schoolblog.marks.domain.entity.Mark;
import pe.edu.upc.schoolblog.student.domain.model.entity.Student;

import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "evaluations")
@Getter
@Setter
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @NotBlank
    @Column(name = "name")
    private String name;
    @NotNull
    @NotBlank
    private String description;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date expirationDay;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date initDay;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="course_id", nullable = false, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (course_id) references courses (id)"))
    private Course course;

}
