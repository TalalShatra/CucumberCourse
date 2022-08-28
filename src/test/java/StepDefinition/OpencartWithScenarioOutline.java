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

import java.util.List;
import java.util.concurrent.TimeUnit;


public class OpencartWithScenarioOutline {

    WebDriver driver;

    @Given("User navigate to openCart")
    public void user_navigate_to_open_cart() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://opencart.abstracta.us/");}

    @When("User search for {string} in Opencart")
    public void user_search_for_in_opencart(String Item) {
        WebElement searchInput = driver.findElement(By.cssSelector("#search>input"));
        searchInput.sendKeys(Item);
        searchInput.sendKeys(Keys.ENTER);

    }
    @Then("User should see results for {string} in Opencart")
    public void user_should_see_results_for_in_opencart(String ResultItem) {
        List<WebElement> searchList = driver.findElements(By.tagName("h4"));
        for (WebElement X : searchList) {
            Assert.assertTrue(X.getText().toLowerCase().contains(ResultItem.toLowerCase()));
        }
        driver.quit();
    }
}
