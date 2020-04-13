package factoryRequest;

public class CustomReponse {

    private String jsonBody;
    private int codeStatus;
    private String message;


    public CustomReponse(String body, int code, String message) {

        this.jsonBody = body;
        this.codeStatus = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getJsonBody() {
        return jsonBody;
    }

    public int getCodeStatus() {
        return codeStatus;
    }

}
