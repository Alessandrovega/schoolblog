package pe.edu.upc.schoolblog.marks.resource;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMarkResource {

    @NotNull
    @NotBlank
    @Min(1)
    private Integer id;

    @NotNull
    @NotBlank
    private  Integer evaluationId;

    @NotNull
    @NotBlank
    private  Integer studentId;

    @NotNull
    @NotBlank
    @Min(0)
    @Max(20)
    private Integer note;

}
