package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (

        features = {"src/main/resources/FeatureFile/Login.feature"}, // Location (Path) of Feature files we want to execute
        glue = {"StepDefinition"} // Location (Name) of Step Definitions Package
)

public class TestRunner extends AbstractTestNGCucumberTests { } // extends
