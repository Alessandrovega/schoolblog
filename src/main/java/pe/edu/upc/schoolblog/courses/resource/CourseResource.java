package pe.edu.upc.schoolblog.courses.resource;

import lombok.*;
import pe.edu.upc.schoolblog.teachers.domain.model.entity.Teacher;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CourseResource {
    private Integer id;
    private String name;
    private String description;
    private String level;
    private String grade;
    private String section;

}
