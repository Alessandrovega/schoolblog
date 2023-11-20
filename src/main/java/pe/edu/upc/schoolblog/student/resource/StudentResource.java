package pe.edu.upc.schoolblog.student.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class StudentResource {  // Output - Response

    private Integer id;
    private String lastName;
    private String firstName;
    private String tiu;
    private String address;
    private String phone;
    private String email;
    private Integer age;

}
