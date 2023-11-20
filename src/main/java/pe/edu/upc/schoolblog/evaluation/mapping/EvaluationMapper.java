package pe.edu.upc.schoolblog.evaluation.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.schoolblog.evaluation.domain.model.entity.Evaluation;
import pe.edu.upc.schoolblog.evaluation.resource.CreateEvaluationResource;
import pe.edu.upc.schoolblog.evaluation.resource.EvaluationResource;
import pe.edu.upc.schoolblog.evaluation.resource.UpdateEvaluationResource;
import pe.edu.upc.schoolblog.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;

public class EvaluationMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public Evaluation toModel(CreateEvaluationResource resource) {

        return this.mapper.map(resource, Evaluation.class);
    }
    public Evaluation toModel(UpdateEvaluationResource resource) {



        return this.mapper.map(resource, Evaluation.class);
    }

    public EvaluationResource toResource(Evaluation evaluation) {
        return this.mapper.map(evaluation,EvaluationResource.class);
    }


}
