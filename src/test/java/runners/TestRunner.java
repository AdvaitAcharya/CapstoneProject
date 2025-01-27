package runners;
 
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
features = {"src/test/resources/features/navigationandcontent.feature", 
		"src/test/resources/features/FormSubmission.feature", 
		"src/test/resources/features/UserRegistration.feature", 
		"src/test/resources/features/Login.feature", 
		"src/test/resources/features/ProfileManagement.feature"},
glue = "stepDefinitions",
plugin = {"pretty", "html:target/cucumber-reports"},
monochrome = true
)
public class TestRunner {
}
/*always change user name and and email password for user Registration before running*/