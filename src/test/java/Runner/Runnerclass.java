package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/resources/Feature/Login.feature",
		glue= {"stepDefinitions"},
		dryRun=true,
		monochrome=true,
		tags="@smoke or @regression or @functional",
		plugin= {"pretty","html:target/Cucumber/reports-html",
				"json:target/Cucumber/reports.json"}
		
		
		
		)

public class  Runnerclass extends AbstractTestNGCucumberTests{
	

	
}
