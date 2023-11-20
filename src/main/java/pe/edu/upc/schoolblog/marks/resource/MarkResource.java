package pe.edu.upc.schoolblog.marks.resource;

import lombok.*;
import pe.edu.upc.schoolblog.evaluation.domain.model.entity.Evaluation;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class MarkResource {

    private Integer id;
    private Evaluation evaluation;
    private Integer note;

}
