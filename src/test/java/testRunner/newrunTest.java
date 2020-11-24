/*
 ***************************************************************************
 *     testRunner class for Assignment1 to run directly from Maven         *
 ***************************************************************************
 */



package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Feature1.feature",
        glue= "Assignment1"
)
public class newrunTest {
}
