package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin={"html:target//cucumber-reports.html"},
		features="src/test/resources/features",
		glue="dbStepdefinitions",
		tags="@dbutil",
		dryRun=false
)

public class Runner {

}
