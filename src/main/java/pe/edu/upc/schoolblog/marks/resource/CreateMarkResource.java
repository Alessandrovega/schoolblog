package pe.edu.upc.schoolblog.marks.resource;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateMarkResource {

    @NotNull
    @NotBlank
    private Integer studentId;

@NotNull
@NotBlank
@Min(0)
@Max(20)
    private Integer note;

@NotNull
    private Integer evaluation_id;

}
