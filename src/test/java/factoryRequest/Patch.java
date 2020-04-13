package factoryRequest;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static helpers.MyValues.*;
import static helpers.MyValues.ACCEPT_JSON_TEXT_ALL;

public class Patch implements IRequest {
    @Override
    public CustomReponse send(String path, String body) {
        WebTarget target = client.target(SERVER_MAIN_URL + path);
        Entity entity = Entity.json(body);
        System.out.println("\nINFO>\t PATCH Request URL :"+SERVER_MAIN_URL + path);
        System.out.println("\nINFO>\t PATCH Requet BODY :"+body);
        Response response_actual = target.request(MediaType.APPLICATION_JSON_TYPE).header(Authentication, Authentication_value).header(ACCEPT,ACCEPT_JSON_TEXT_ALL).method("PATCH", entity);
        CustomReponse response = new CustomReponse(response_actual.readEntity(String.class).toString(),
                response_actual.getStatus(),
                response_actual.getStatusInfo().toString());

        response_actual.close();
        System.out.println("\nINFO>\t PATCH Response BODY :"+response.getJsonBody());
        System.out.println("\nINFO>\t PATCH Response CODE :"+response.getCodeStatus());
        return response;
    }
}
