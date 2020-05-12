package factoryRequest;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static helpers.MyValues.*;

public class DeleteToken implements IRequest {
    @Override
    public CustomReponse send(String path, String body) {
        WebTarget target = client.target(SERVER_MAIN_URL+ path);
        System.out.println("\nINFO>\t DELETE Request URL :"+SERVER_MAIN_URL + path);
        System.out.println("\nINFO>\t DELETE Requet BODY :"+body);
        Response response_actual = target.request(MediaType.APPLICATION_JSON_TYPE).header("Token", TokenValue).delete();
        CustomReponse response = new CustomReponse("",
                response_actual.getStatus(),
                response_actual.getStatusInfo().toString());
        response_actual.close();
        System.out.println("\nINFO>\t DELETE Response BODY :"+response.getJsonBody());
        System.out.println("\nINFO>\t DELETE Response CODE :"+response.getCodeStatus());
        return response;
    }
}
