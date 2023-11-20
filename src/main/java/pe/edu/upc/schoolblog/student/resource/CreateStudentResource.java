package pe.edu.upc.schoolblog.student.resource;


import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentResource {    // Input - Request

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
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
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
