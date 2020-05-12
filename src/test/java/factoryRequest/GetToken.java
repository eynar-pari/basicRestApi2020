package factoryRequest;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static helpers.MyValues.*;

public class GetToken implements IRequest {
    @Override
    public CustomReponse send(String path, String body) {
        WebTarget target = client.target(SERVER_MAIN_URL + path);
        Response response_actual = target.request(MediaType.APPLICATION_JSON_TYPE).header("Token", TokenValue).header(ACCEPT,ACCEPT_JSON_TEXT_ALL).get();
        System.out.println("\nINFO>\t GET Request URL :"+SERVER_MAIN_URL + path);
        System.out.println("\nINFO>\t GET Requet BODY :"+body);
        CustomReponse response = new CustomReponse(response_actual.readEntity(String.class).toString(),
                response_actual.getStatus(),
                response_actual.getStatusInfo().toString());
        response_actual.close();
        System.out.println("\nINFO>\t GET Response BODY :"+response.getJsonBody());
        System.out.println("\nINFO>\t GET Response CODE :"+response.getCodeStatus());
        return response;
    }
}
