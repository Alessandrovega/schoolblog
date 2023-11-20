package pe.edu.upc.schoolblog.principals.resource;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePrincipalResource {

    @NotNull
    @NotBlank
    @Min(1)
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 30, message = "LastName has  2 - 30 characters")
    private String lastName;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String email;

    @Size(min = 9, max = 9, message = "Phone has 9 characters")
    private String phone;

    @NotNull
    @Past
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @NotNull
    @NotBlank
    private String address;

    @Min(18)
    @NotNull
    private Integer age;
}
