package pe.edu.upc.schoolblog.principals.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "principals")
public class Principal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 30, message = "LastName has  2 - 30 characters")
    @Column(name = "last_name", length = 30, nullable = false)
    private String lastName;

    @NotNull
    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @NotBlank
    @Column(name = "email", nullable = false)
    private String email;

    @Size(min = 9, max = 9, message = "Phone has 9 characters")
    @Column(name = "phone")
    private String phone;

    @NotNull
    @Past
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @NotNull
    @NotBlank
    @Column(name = "address")
    private String address;

    @Min(18)
    @NotNull
    @Column(name = "age", nullable = false)
    private Integer age;

}
