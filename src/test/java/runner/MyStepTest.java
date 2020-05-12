package runner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import factoryRequest.CustomReponse;
import factoryRequest.FactoryRequest;
import helpers.JsonUtil;
import jdk.nashorn.internal.parser.Token;
import org.json.JSONException;
import org.junit.Assert;
import static helpers.MyValues.*;
import java.util.HashMap;
import java.util.Map;

public class MyStepTest {

    public static CustomReponse globalResponse;
    @When("^I send a (POST|PUT|DELETE|GET) request to (.*) end point with the json$")
    public void iSendAPOSTRequestToProjectsJsonEndPointWithTheJson(String method, String path, String body) throws Throwable {
        globalResponse= FactoryRequest.make(method.toLowerCase()).send(this.replaceString(path),this.replaceString(body));
    }

    public Map<String,String> globalVariables=new HashMap<>();

    @When("^I send a (DELETE|GET) request to (.*) end point with token$")
    public void iSendAPOSTRequestToProjectsJsonEndPointWithTheJsonToken(String method, String path, String token) throws Throwable {
        TokenValue=this.replaceString(token);
        globalResponse= FactoryRequest.make(method.toLowerCase()+"_token").send(this.replaceString(path),"");
    }

    @Then("^the response code should be (\\d+)$")
    public void theResponseCodeShouldBe(int expected) throws Throwable {
        Assert.assertEquals("The expected is not equal to the actual",expected,globalResponse.getCodeStatus());
    }

    // Gherkins
    @Given("^I have connection with (.*)$")
    public void iHaveConnectionWithTodoLy(String value) {

    }

    @And("^I expected the (.*) is displayed in json response$")
    public void iExpectedTheNAMEIsDisplayedInJsonResponse(String expectedValue) {
        String actualResult= globalResponse.getJsonBody();
        expectedValue= this.replaceString(expectedValue);
        Assert.assertTrue("ERROR !! "+expectedValue+" is not in "+actualResult,actualResult.contains(expectedValue));
    }

    @And("^I save the attribute (.*) in the variable : (.*)$")
    public void iSaveTheAttributeIdInTheVariableID_PROYECTO(String attribute,String nameVar) {
        String valueAttribute= JsonUtil.getJsonValue(globalResponse.getJsonBody(),attribute);
        System.out.println("INFO > Attribute : ["+attribute+ "] value : ["+valueAttribute+"]" );
        globalVariables.put(nameVar,valueAttribute);
    }

    private String replaceString(String value){

        for (String key:globalVariables.keySet()){
            value=value.replace(key,globalVariables.get(key));
        }
        return value;
    }


    @And("^I expected a json response equal to$")
    public void iExpectedAJsonResponseEqualTo(String expectedResult) throws JSONException {
        expectedResult=this.replaceString(expectedResult);
        String actualResult=globalResponse.getJsonBody();
        Assert.assertTrue("ERROR los json comparados son distintos",JsonUtil.areEqualsJsonObject(expectedResult,actualResult));
    }

    @And("^I compare the value of (.*) is equal to$")
    public void iCompareTheValueOfSTATUS_ITEMIsEqualTo(String key,String expectedResult) {
       expectedResult= this.replaceString(expectedResult);
       String actualResult=this.replaceString(key);
       Assert.assertEquals("ERROR",expectedResult,actualResult);
    }

    @And("^I expected the (.*) is not displayed in json response$")
    public void iExpectedTheCUCUMBERIsNotDisplayedInJsonResponse(String expectedValue) {
        String actualResult= globalResponse.getJsonBody();
        expectedValue= this.replaceString(expectedValue);
        Assert.assertFalse("ERROR !! "+expectedValue+" is not in "+actualResult,actualResult.contains(expectedValue));

    }

    public static void main (String [] args){
        for (int i = 3844234; i <= 3845631; i++) {
            FactoryRequest.make("delete").send("projects/"+i+".json","");
        }
    }
}

