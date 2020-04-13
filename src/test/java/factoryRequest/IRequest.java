package factoryRequest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public interface IRequest {
    Client client = ClientBuilder.newBuilder().build();
    CustomReponse send(String path, String body);
}
