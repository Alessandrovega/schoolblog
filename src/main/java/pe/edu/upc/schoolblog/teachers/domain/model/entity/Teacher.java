package pe.edu.upc.schoolblog.teachers.domain.model.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;

import lombok.Getter;

import lombok.Setter;

import org.springframework.format.annotation.DateTimeFormat;
import pe.edu.upc.schoolblog.courses.domain.entity.Course;

import java.util.Date;
import java.util.List;

@Entity

@Table(name = "teachers")

@Getter

@Setter

public class Teacher {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 30)
    @Column(name = "last_name", length = 30, nullable = false)
    private String lastName;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 30)
    @Column(name = "first_name", length = 30, nullable = false)
    private String firstName;


    @NotNull
    @NotBlank
    @Column(name = "email", nullable = false)
    private String email;


    @NotNull
    @NotBlank
    @Size(min = 9, max = 9)
    @Column(name = "phone", nullable = false, length = 9)
    private String phone;

    @NotNull
    @NotBlank
    @Column(name = "address", nullable = false)
    private String address;

    @NotNull
    @Past
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;

}
