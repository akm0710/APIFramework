package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\LAM\\ashish\\AshishApiFramework\\src\\test\\java\\features\\placeValidation.feature",
		glue= {"stepDefinations"}
		)
public class TestRunner {

}
