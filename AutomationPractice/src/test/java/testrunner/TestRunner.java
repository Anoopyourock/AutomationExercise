package testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//To run the features file

@RunWith(Cucumber.class)
@CucumberOptions(features = "../AutomationPractice/src/test/resources/features/", 
				 glue = "stepdefination", 
				 tags = "@SmokeTest", 
				 dryRun = false, 
				 monochrome = true, 
				 plugin = {"pretty", 
						   "html:target/cucumber-reports/cucumber.html", 
						   "json:target/json_output/cucumber.json" })
				
public class TestRunner {

}
