package pe.edu.upc.schoolblog.teachers.resource;

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

public class UpdateTeacherResource {

    @NotNull

    @NotBlank

    private Integer id;

    @NotNull

    @NotBlank

    @Size(min = 2, max = 30)

    private String lastName;

    @NotNull

    @NotBlank

    @Size(min = 2, max = 30)

    private String firstName;


    @NotBlank
    @NotNull
    private String email;


    @NotNull
    @NotBlank
    @Size(min = 9, max = 9)
    private String phone;

    @NotNull
    @NotBlank
    private String address;

    @NotNull
    @Past
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    @Temporal(TemporalType.DATE)
    private Date date;
}
