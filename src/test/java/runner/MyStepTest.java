package runner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import factoryRequest.CustomReponse;
import factoryRequest.FactoryRequest;
import org.junit.Assert;

public class MyStepTest {

    public static CustomReponse globalResponse;


    @When("^I send a (POST|PUT|DELETE|GET) request to (projects.json) end point with the json$")
    public void iSendAPOSTRequestToProjectsJsonEndPointWithTheJson(String method, String path, String body) throws Throwable {
        globalResponse= FactoryRequest.make(method.toLowerCase()).send(path,body);
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
        Assert.assertTrue("ERROR !! "+expectedValue+" is not in "+actualResult,actualResult.contains(expectedValue));
    }
}

