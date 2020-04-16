package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import static helpers.MyValues.HOST;

/**
 * Created by Eynar.
 */
@RunWith(Cucumber.class)
class Runner {

    // HOOKS
    @Before()
    public void beforeScenario(Scenario scenario) {
            System.out.println(".............BEFORE");
    }


    @After()
    public void afterScenario(Scenario scenario) {
            System.out.println("................AFTER");
    }
}
