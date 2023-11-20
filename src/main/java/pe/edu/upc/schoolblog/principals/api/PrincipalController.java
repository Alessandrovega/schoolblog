package pe.edu.upc.schoolblog.principals.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.schoolblog.principals.domain.entity.Principal;
import pe.edu.upc.schoolblog.principals.domain.service.PrincipalService;
import pe.edu.upc.schoolblog.principals.mapping.PrincipalMapper;
import pe.edu.upc.schoolblog.principals.resource.CreatePrincipalResource;
import pe.edu.upc.schoolblog.principals.resource.PrincipalResource;
import pe.edu.upc.schoolblog.principals.resource.UpdatePrincipalResource;


import java.util.List;

@Tag(name = "Principals")
@RestController
@RequestMapping("principals")
 @AllArgsConstructor
public class PrincipalController {
    private final PrincipalService principalService;
    private final PrincipalMapper mapper;

    @GetMapping
    public List<Principal> fetchAll(){return principalService.fetchAll();}

    @GetMapping("{id}")
    public ResponseEntity<PrincipalResource> fetchId(@PathVariable Integer id){
        return new ResponseEntity<>(
                this.mapper.toResource(
                        principalService.fetchById(id).get()),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PrincipalResource> save(@RequestBody CreatePrincipalResource resource){
        return new ResponseEntity<>(
                mapper.toResource(principalService.save(mapper.toModel(resource))),
                HttpStatus.CREATED
        );
    }

    @PutMapping("{id}")
    public ResponseEntity<PrincipalResource> update (@PathVariable Integer id,
                                                     @RequestBody UpdatePrincipalResource resource){
        if (id.equals(resource.getId())){
            PrincipalResource principalResource = mapper.toResource(
                    principalService.update(mapper.toModel(resource))
            );
            return new ResponseEntity<>(principalResource, HttpStatus.OK);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        if (principalService.deleteById(id)){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }


}