package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = {"src/main/resources/FeatureFile"},
        glue = {"StepDefinition"}
)

public class TestRunnerAllFeatureFiles extends AbstractTestNGCucumberTests { }
