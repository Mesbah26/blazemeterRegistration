package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Page.RegistrationPage;

import java.time.Duration;

public class RegistrationStep {

    WebDriver driver;
    WebDriverWait wait;
    RegistrationPage  registrationPage;
    
    @Given("I am on the BlazeMeter registration page")
    public void i_am_on_the_blaze_meter_registration_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.blazemeter.com/signup");

        RegistrationPage      registrationPage = new RegistrationPage(driver);

        wait.until(ExpectedConditions.visibilityOf(registrationPage.pageTitle));
        Assert.assertTrue(registrationPage.isPageTitleDisplayed());
    }

    @When("I enter first name {string}")
    public void i_enter_first_name(String firstName) {
        registrationPage.enterFirstName(firstName);
    }

    @When("I enter last name {string}")
    public void i_enter_last_name(String lastName) {
        registrationPage.enterLastName(lastName);
    }

    @When("I enter email {string}")
    public void i_enter_email(String email) {
        registrationPage.enterEmail(email);
    }

    @When("I leave the email field blank")
    public void i_leave_the_email_field_blank() {
        registrationPage.clearEmail();
    }

    @When("I enter company {string}")
    public void i_enter_company(String company) {
        registrationPage.enterCompany(company);
    }

    @When("I click the Register button")
    public void i_click_the_register_button() {
        registrationPage.clickRegister();
    }

    @Then("I should see a confirmation message")
    public void i_should_see_a_confirmation_message() {
        wait.until(ExpectedConditions.visibilityOf(registrationPage.confirmationMessage));
        Assert.assertTrue(registrationPage.isConfirmationDisplayed());
    }

    @Then("I should be redirected to my dashboard")
    public void i_should_be_redirected_to_my_dashboard() {
        wait.until(ExpectedConditions.urlContains("dashboard"));
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        driver.quit();
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedErrorMessage) {
        wait.until(ExpectedConditions.visibilityOf(registrationPage.errorMessage));
        Assert.assertEquals(registrationPage.getErrorMessageText(), expectedErrorMessage);
    }

    @Then("I should remain on the registration page")
    public void i_should_remain_on_the_registration_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("signup"));
        driver.quit();
    }
}
