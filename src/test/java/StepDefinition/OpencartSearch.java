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

public class OpencartSearch {
    WebDriver driver;

    @Given("User navigate to openCart website")
    public void user_navigate_to_open_cart_website() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://opencart.abstracta.us/");
    }
    @When("User search {string}")
    public void user_search(String searchData) {
        WebElement searchInput = driver.findElement(By.cssSelector("#search>input"));
        searchInput.sendKeys(searchData);
        searchInput.sendKeys(Keys.ENTER);
    }
    @Then("User see results {string}")
    public void user_see_results(String searchData) {
        List<WebElement> searchList = driver.findElements(By.tagName("h4"));
        for (WebElement X: searchList){
            Assert.assertTrue(X.getText().toLowerCase().contains(searchData.toLowerCase()));
        }

        driver.quit();

    }
}
