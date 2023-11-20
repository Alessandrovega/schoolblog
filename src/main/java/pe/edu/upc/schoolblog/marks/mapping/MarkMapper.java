package pe.edu.upc.schoolblog.marks.mapping;



import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.schoolblog.marks.domain.entity.Mark;
import pe.edu.upc.schoolblog.marks.resource.CreateMarkResource;
import pe.edu.upc.schoolblog.marks.resource.MarkResource;
import pe.edu.upc.schoolblog.marks.resource.UpdateMarkResource;
import pe.edu.upc.schoolblog.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
public class MarkMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public Mark toModel (CreateMarkResource resource){
        return this.mapper.map(resource,Mark.class);

    }

    public Mark toModel (UpdateMarkResource resource){

        return this.mapper.map(resource,Mark.class);
    }

    public MarkResource toResource (Mark mark){

        return this.mapper.map(mark,MarkResource.class);
    }
}
