package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Regression", // adding (or @Smoke) will run both smoke and regression
        features = {"src/main/resources/FeatureFile"},
        glue = {"StepDefinition"},
        plugin = {"html:target/report/RegressionTestResult.html"}
)

public class regressionTest extends AbstractTestNGCucumberTests { }
