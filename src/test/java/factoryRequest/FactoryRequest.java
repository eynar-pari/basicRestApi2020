package factoryRequest;

public class FactoryRequest {

    public static final String  PATCH="patch";
    public static final String  PUT="put";
    public static final String  GET="get";
    public static final String  POST="post";
    public static final String  DELETE="delete";
    public static final String  DELETE_TOKEN="delete_token";
    public static final String  GET_TOKEN="get_token";

    public static IRequest make (String typeRequest){
        IRequest request;

        switch (typeRequest.toLowerCase()){
            case PATCH:
                request = new Patch();
                break;
            case PUT:
                request= new Put();
                break;
            case GET:
                request= new Get();
                break;
            case POST:
                request= new Post();
                break;
            case DELETE:
                request= new Delete();
                break;
            case DELETE_TOKEN:
                request= new DeleteToken();
                break;
            case GET_TOKEN:
                request= new GetToken();
                break;
            default:
                request= new Get();
                break;

        }
        return request;
    }

}
