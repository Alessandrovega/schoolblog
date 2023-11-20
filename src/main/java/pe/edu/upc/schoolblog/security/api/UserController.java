package pe.edu.upc.schoolblog.security.api;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.schoolblog.security.domain.service.UserService;
import pe.edu.upc.schoolblog.security.domain.service.communication.AuthenticateRequest;
import pe.edu.upc.schoolblog.security.domain.service.communication.RegisterRequest;
import pe.edu.upc.schoolblog.security.mapping.UserMapper;
import pe.edu.upc.schoolblog.security.resource.UserResource;


@Tag(name = "Users", description = "Create, read, update and delete users")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/userss")
public class UserController {

    private final UserService userService;
    private final UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }


    @PostMapping("/auth/sign-in")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody AuthenticateRequest request) {
        //if(request!=null) throw new RuntimeException("El request esta vacio");
        return userService.authentication(request);
        //return ResponseEntity.ok(request);
    }

    @PostMapping("/auth/sign-up")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public ResponseEntity<?> getAllUsers(Pageable pageable) {
        Page<UserResource> resources = mapper.modelListToPage(userService.getAll(), pageable);
        return ResponseEntity.ok(resources);
    }

}