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

    /**
     * This method compare two simple json
     *
     * @param jsonExpected it is a json. Example : {\"key1\":\"value1\",\"key2\":\"value2\"}
     * @param jsonActual   it is a json. Example : {\"key1\":\"value1\",\"key2\":\"value2\"}
     * @return
     * @throws JSONException it throws is a json is invalid.
     */
    public static boolean areEqualsJsonObject(String jsonExpected, String jsonActual) throws JSONException {
        boolean areEqualJsonObject = true;
        JSONObject jsonObjectExpected = JsonUtil.convertToJSONObject(jsonExpected);
        JSONObject jsonObjectActual = JsonUtil.convertToJSONObject(jsonActual);
        Iterator<?> keys = jsonObjectExpected.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String valueExpected = String.valueOf(jsonObjectExpected.get(key));
            String valueActual = String.valueOf(jsonObjectActual.get(key));
            if (valueExpected.equals("IGNORE")){
                System.out.println("INFO>\tIgnoring.... Attribute : "+key+ " with value : "+valueActual);

            } else {
                if (!valueExpected.equals(valueActual)){
                    System.out.println("INFO>\tProperty: [" + key + "] -> Comparing Expected Result : '" + valueExpected +
                            "' and Actual Result : '" + valueActual + "'" + " are equal:" + valueExpected.equals(valueActual));

                    areEqualJsonObject = false;
                }
            }
        }
        return areEqualJsonObject;
    }
}

