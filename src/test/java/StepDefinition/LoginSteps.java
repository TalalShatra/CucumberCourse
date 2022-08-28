package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    @Given("User navigate to website")
    public void user_navigate_to_website() {
        System.out.println("Navigate to website");

    }
    @When("User enter valid username and password")
    public void user_enter_valid_username_and_password() {
        System.out.println("Enter valid username");
        System.out.println("Enter valid password");
        System.out.println("Click submit button");

    }
    @Then("User should login successfully")
    public void user_should_login_successfully() {
        System.out.println("Login successful");

    }
    @When("User enter valid username and invalid password")
    public void user_enter_valid_username_and_invalid_password() {
        System.out.println("Enter valid username");
        System.out.println("Enter invalid password");
        System.out.println("Click submit button");
    }
    @Then("Login should fail")
    public void login_should_fail() {
        System.out.println("Login fail");

    }

}
