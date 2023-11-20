package pe.edu.upc.schoolblog.security.resource;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
public class RoleResource {
    private Long id;
    private String name;
}