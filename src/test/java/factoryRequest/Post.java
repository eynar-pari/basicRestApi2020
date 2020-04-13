package factoryRequest;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static helpers.MyValues.Authentication;
import static helpers.MyValues.Authentication_value;
import static helpers.MyValues.SERVER_MAIN_URL;


public class Post implements IRequest{

    public CustomReponse send(String path, String body) {
        Response response_actual;
        WebTarget target = client.target(SERVER_MAIN_URL + path);
        System.out.println("\nINFO>\t POST Request URL :"+SERVER_MAIN_URL + path);
        System.out.println("\nINFO>\t POST Requet BODY :"+body);
        Entity entity = Entity.json(body);
        response_actual = target.request(MediaType.APPLICATION_JSON_TYPE).header(Authentication, Authentication_value).post(entity);
        CustomReponse response = new CustomReponse(response_actual.readEntity(String.class).toString(),
                response_actual.getStatus(),
                response_actual.getStatusInfo().toString());
        response_actual.close();
        System.out.println("\nINFO>\t POST Response BODY :"+response.getJsonBody());
        System.out.println("\nINFO>\t POST Response CODE :"+response.getCodeStatus());
        return response;
    }
}
