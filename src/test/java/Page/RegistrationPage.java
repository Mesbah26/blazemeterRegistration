package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    WebDriver driver;
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    @FindBy(id = "firstName")
    WebElement firstNameField;

    @FindBy(id = "lastName")
    WebElement lastNameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "company")
    WebElement companyField;

    @FindBy(xpath = "//button[contains(text(), 'Register')]")
    WebElement registerButton;

    @FindBy(xpath = "//h1[contains(text(), 'Create Your Account')]")
	public
    WebElement pageTitle;

    @FindBy(xpath = "//div[contains(text(), 'Registration successful') or contains(text(), 'Welcome to BlazeMeter')]")
	public
    WebElement confirmationMessage;

    @FindBy(xpath = "//div[contains(@class, 'error')]")
	public
    WebElement errorMessage;



    
    public void enterFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void clearEmail() {
        emailField.clear();
    }

    public void enterCompany(String company) {
        companyField.clear();
        companyField.sendKeys(company);
    }

    public void clickRegister() {
        registerButton.click();
    }

    public boolean isPageTitleDisplayed() {
        return pageTitle.isDisplayed();
    }

    public boolean isConfirmationDisplayed() {
        return confirmationMessage.isDisplayed();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}
