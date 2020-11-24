/*
 ***************************************************************************
 *     testRunner class for Assignment2 to run directly from Maven         *
 ***************************************************************************
 */

package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Feature_REST.feature",
        glue= "Assignment2")
public class ApiTest {
}
