package pe.edu.upc.schoolblog.evaluation.resource;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.criteria.CriteriaBuilder;
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
public class CreateEvaluationResource {    // Input - Request

    @NotNull
    @NotBlank
    @Size(min = 2, max = 30)
    private String Name;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 30)
    private String description;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date expirationDay;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date initDay;

    @NotNull
    private Integer course_id;

}
