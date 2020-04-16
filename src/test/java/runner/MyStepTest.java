package runner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import factoryRequest.CustomReponse;
import factoryRequest.FactoryRequest;
import helpers.JsonUtil;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class MyStepTest {

    public static CustomReponse globalResponse;
    public Map<String,String> globalVariables=new HashMap<>();

    @When("^I send a (POST|PUT|DELETE|GET) request to (.*) end point with the json$")
    public void iSendAPOSTRequestToProjectsJsonEndPointWithTheJson(String method, String path, String body) throws Throwable {
        globalResponse= FactoryRequest.make(method.toLowerCase()).send(this.replaceString(path),this.replaceString(body));
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


}

