package pe.edu.upc.schoolblog.schedule.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.schoolblog.courses.domain.entity.Course;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank
    @Column(name = "day_of_week", nullable = false)
    private String dayOfWeek;

    @NotNull
    @NotBlank
    @Column(name = "start_time", nullable = false)
    private String startTime;



    @JsonIgnore
    @ManyToMany(mappedBy = "schedules")
    private List<Course> courses;
}
