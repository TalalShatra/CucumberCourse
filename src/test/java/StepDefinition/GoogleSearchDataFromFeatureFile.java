package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleSearchDataFromFeatureFile {

    WebDriver driver;

    @Given("User navigate to Google website")
    public void user_navigate_to_google_website() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
    }
    @When("User search for {string} in Google")
    public void user_search_for_in_google(String searchData) {
        WebElement searchInput = driver.findElement(By.cssSelector("input[title='Search']"));
        searchInput.sendKeys(searchData);
        searchInput.sendKeys(Keys.ENTER);

    }
    @Then("User should see results {string} related in Google")
    public void user_should_see_results_related_in_google(String searchData) {
        WebElement searchResult = driver.findElement(By.tagName("h3"));
        System.out.println("Search Result text: "+ searchResult.getText());
        Assert.assertTrue(searchResult.getText().toLowerCase().contains(searchData.toLowerCase()));

        driver.quit();

    }
}
