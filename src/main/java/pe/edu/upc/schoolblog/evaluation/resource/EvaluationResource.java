package pe.edu.upc.schoolblog.evaluation.resource;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationResource {  // Output - Response

    private Integer id;
    private String name;
    private String description;
    private Date expirationDay;
    private Date initDay;
}
