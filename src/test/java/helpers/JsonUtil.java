package helpers;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
public class JsonUtil {

    public static JSONObject convertToJSONObject(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            return jsonObject;
        } catch (JSONException e) {
            throw new IllegalArgumentException(String.format("Cannot convert to JSONObject because the json=['%s'] is invalid.", json), e);
        }
    }

    /**
     * Get a value from JSONObject.
     *
     * @param jsonObject   JSON that contains the property to extract
     * @param propertyName name of the property to extract
     * @return
     */
    public static String getJsonValue(String jsonObject, String propertyName) {
        try {
            String value = JsonUtil.convertToJSONObject(jsonObject).get(propertyName).toString();
            return value;
        } catch (JSONException e) {
            throw new IllegalArgumentException(String.format("Cannot get propertyName=['%s'] from JSONObject.", propertyName), e);
        }
    }

}
