package StepDefinition;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class ZeroBank {

    WebDriver driver;
// Scenario1
    @Given("Navigate to Zero Bank web page")
    public void navigate_to_zero_bank_web_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/login.html");
    }
    @Given("Login to your account in Zero Bank")
    public void login_to_your_account_in_zero_bank() {
        WebElement loginInput = driver.findElement(By.id("user_login"));
        loginInput.sendKeys("username");
        WebElement passwordInput = driver.findElement(By.id("user_password"));
        passwordInput.sendKeys("password");
        WebElement signInButton = driver.findElement(By.cssSelector("input[type='submit']"));
        signInButton.click();
        driver.navigate().back();
    }
    @When("navigate to Pay Bills page")
    public void navigate_to_pay_bills_page() {
        WebElement onlineBankingMenu = driver.findElement(By.id("onlineBankingMenu"));
        onlineBankingMenu.click();
        WebElement payBillLink = driver.findElement(By.id("pay_bills_link"));
        payBillLink.click();
    }
    @When("add New Payee {string}")
    public void add_new_payee(String name) {
        WebElement addNewPayee = driver.findElement(By.xpath("//*[text()='Add New Payee']"));
        addNewPayee.click();
        WebElement payeeNameInput = driver.findElement(By.cssSelector("input[id='np_new_payee_name']"));
        payeeNameInput.sendKeys(name);
        WebElement payeeAddressInput = driver.findElement(By.id("np_new_payee_address"));
        payeeAddressInput.sendKeys("16 Hill Street");
        WebElement accountInput = driver.findElement(By.id("np_new_payee_account"));
        accountInput.sendKeys("12345678");
        WebElement addButton = driver.findElement(By.cssSelector("input[value='Add']"));
        addButton.click();
    }
    @Then("you should see a message")
    public void you_should_see_a_message() {
        WebElement addPayeeMessage = driver.findElement(By.cssSelector("div[id='alert_content']"));
        Assert.assertTrue(addPayeeMessage.getText().contains("successfully created"));

        driver.quit();
    }


// Scenario2
    @When("add Purchase foreign currency {string}")
    public void add_purchase_foreign_currency(String amount) {
        WebElement purchaseForeignCurrency = driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']"));
        purchaseForeignCurrency.click();
        WebElement currencyButton = driver.findElement(By.id("pc_currency"));
        Select selectCurrency = new Select(currencyButton);
        selectCurrency.selectByVisibleText("Canada (dollar)");
        WebElement amountInput = driver.findElement(By.id("pc_amount"));
        amountInput.sendKeys(amount);
        WebElement usdButton = driver.findElement(By.name("inDollars"));
        usdButton.click();
        WebElement purchaseButton = driver.findElement(By.id("purchase_cash"));
        purchaseButton.click();
    }
    @Then("you should see Success message")
    public void you_should_see_success_message() {
        WebElement purchaseMessage = driver.findElement(By.id("alert_content"));
        Assert.assertEquals(purchaseMessage.getText(), "Foreign currency cash was successfully purchased.");

        driver.quit();
    }


// Scenario3
    @When("navigate to Transfer Funds page")
    public void navigate_to_transfer_funds_page() {
        WebElement transferFundsLink = driver.findElement(By.id("transfer_funds_link"));
        transferFundsLink.click();
    }
    @When("transfer Funds {string}")
    public void transfer_funds(String amount) {
        WebElement fromAccountInput = driver.findElement(By.cssSelector("select[name='fromAccountId']"));
        Select fromAccount = new Select(fromAccountInput);
        fromAccount.selectByValue("4");
        WebElement toAccountInput = driver.findElement(By.cssSelector("select[name='toAccountId']"));
        Select toAccount = new Select(toAccountInput);
        fromAccount.selectByValue("2");
        WebElement amountToTransfer = driver.findElement(By.id("tf_amount"));
        amountToTransfer.sendKeys(amount);
        WebElement continueButton = driver.findElement(By.xpath("//*[text()='Continue']"));
        continueButton.click();
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

    }
    @Then("you should see Success Transfer message")
    public void you_should_see_success_transfer_message() {
        WebElement transferMessage = driver.findElement(By.cssSelector("div[class='alert alert-success']"));
        Assert.assertTrue(transferMessage.getText().contains("You successfully submitted your transaction"));

        driver.quit();
    }
}
