package pe.edu.upc.schoolblog.courses.resource;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCourseResource {
    @NotNull
    @NotBlank
    private Integer id;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String description;

    @NotNull
    @NotBlank
    private String level;

    @NotNull
    @NotBlank
    private String grade;

    @NotNull
    @NotBlank
    private String section;

    @NotNull
    private Integer teacher_id;
}
