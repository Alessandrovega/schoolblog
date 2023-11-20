package pe.edu.upc.schoolblog.security.domain.service.communication;

import pe.edu.upc.schoolblog.security.resource.UserResource;
import pe.edu.upc.schoolblog.shared.domain.service.communication.BaseResponse;

public class RegisterResponse extends BaseResponse<UserResource> {
    public RegisterResponse(String message) {
        super(message);
    }

    public RegisterResponse(UserResource resource) {
        super(resource);
    }
}