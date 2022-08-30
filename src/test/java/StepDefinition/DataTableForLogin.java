package StepDefinition;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataTableForLogin {
    WebDriver driver;

    @Given("Navigate to demoWebShop")
    public void navigate_to_demo_web_shop() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demowebshop.tricentis.com/login");
    }
    @When("User enter invalid email address")
    public void user_enter_invalid_email_address(io.cucumber.datatable.DataTable dataTable) {

        WebElement emailInput = driver.findElement(By.id("Email"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[value='Log in']"));
        List<String> testData = dataTable.asList();
        for (String data : testData){
            emailInput.clear();
            emailInput.sendKeys(data);
            submitButton.click();
            WebElement errorMessage = driver.findElement(By.className("field-validation-error"));
            Assert.assertTrue(errorMessage.isDisplayed());
        }
    }
    @Then("User should see a warning")
    public void user_should_see_a_warning() {
        driver.quit();

    }
}
