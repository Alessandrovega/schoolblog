package pe.edu.upc.schoolblog.security.domain.service.communication;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.schoolblog.security.resource.AuthenticateResource;
import pe.edu.upc.schoolblog.shared.domain.service.communication.BaseResponse;

public class AuthenticateResponse extends BaseResponse<AuthenticateResource> {

    public AuthenticateResponse(String message) {
        super(message);
    }

    public AuthenticateResponse(AuthenticateResource resource) {
        super(resource);
    }

}