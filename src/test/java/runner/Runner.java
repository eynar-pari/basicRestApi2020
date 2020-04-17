package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Eynar.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty","json:build/reports/cucumber/report.json"})
public class Runner {

    // HOOKS
    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println(".............BEFORE"+scenario.getName());
        System.out.println(".............BEFORE"+scenario.getSourceTagNames());

    }


    @After()
    public void afterScenario(Scenario scenario) {
            System.out.println("................AFTER");
    }
}
