package pe.edu.upc.schoolblog.student.resource;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentResource {
    @NotNull
    @NotBlank
    @Min(1)
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 30)
    private String lastName;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 30)
    private String firstName;

    @NotNull
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @NotNull
    @NotBlank
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @NotBlank
    private String phone;

    @NotNull
    private Integer age;

    @NotNull
    @NotBlank
    @Size(min = 9, max = 9)
    private String tiu;

    @NotNull
    @NotBlank
    private String Address;

}
