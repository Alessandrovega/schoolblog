package pe.edu.upc.schoolblog.principals.resource;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PrincipalResource {
    private Integer id;
    private String name;
    private String lastName;
    private Date birthday;
    private Integer age;
    private String email;
    private String phone;
    private String address;
}
