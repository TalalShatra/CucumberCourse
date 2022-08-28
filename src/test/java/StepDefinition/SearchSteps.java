package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {

    @Given("User go to Search page")
    public void user_go_to_search_page() {
        System.out.println("GO to Search page");

    }
    @When("User Search for Cucumber")
    public void user_search_for_cucumber() {
        System.out.println("Search for Cucumber");

    }
    @Then("All the results should be displayed for Cucumber")
    public void all_the_results_should_be_displayed_for_cucumber() {
        System.out.println("All search Results displayed for Cucumber");

    }
    @When("User Search for SDET")
    public void user_search_for_sdet() {
        System.out.println("Search for SDET");
    }
    @Then("All the results should be displayed for SDET")
    public void all_the_results_should_be_displayed_for_sdet() {
        System.out.println("All search Results displayed for SDET");

    }
}
