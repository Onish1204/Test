package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features", glue = {"stepDefinition"}, monochrome = true, plugin = {"pretty", "html:Reports"}, tags = "@Assignment")
public class TestRunner {

}
