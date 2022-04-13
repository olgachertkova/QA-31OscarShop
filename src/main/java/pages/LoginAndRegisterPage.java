package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginAndRegisterPage extends PageBase {
    public LoginAndRegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "register_form")
    WebElement registerForm;

    public boolean loginAndRegistrationFormIsOpened() {
        return registerForm.isDisplayed();
    }

    public void fillEmailField(String email) {
        inputText(driver.findElement(By.id("id_registration-email")), email);
    }

    public void fillPasswordField(String password) {
        inputText(driver.findElement(By.id("id_registration-password1")), password);
    }

    public void fillConfirmPasswordField(String password) {
        inputText(driver.findElement(By.id("id_registration-password2")), password);
    }


    public void clickOnRegisterButton() {
        click(driver.findElement(By.cssSelector("[name=\"registration_submit\"]")));
    }

    public boolean loginFormIsDisplayed() {
        return registerForm.isDisplayed();
    }

    @FindBy(id = "id_login-username")
    WebElement emailField;
    @FindBy(id = "id_login-password")
    WebElement passwordField;

    public void fillLoginForm(String email, String password) {
        inputText(emailField, email);
        inputText(passwordField, password);
    }

    @FindBy(xpath = "//button[@name='login_submit']")
    WebElement btnLogin;

    public void clickBTNLogIn() {
        btnLogin.click();
    }

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    WebElement logAllert;

    public boolean allertIsDisplayed() {
        return logAllert.isDisplayed();
    }

    @FindBy(xpath = "//*[contains(text(),'Oops! We found some errors')]")
    WebElement someErrors;

    public boolean massageErrorIsDisplaeyd() {
        return someErrors.isDisplayed();
    }

    @FindBy(xpath = "//div[@style='visibility: visible;']")
    WebElement messWrongFormat;

    public boolean massageWrongFormatIsDisplayed()  {
       waitUntilElementVisible(messWrongFormat, 10);
        return messWrongFormat.isDisplayed();
    }

    public void fillEmailAddress(String email) {
        inputText(emailField, email);
    }
    @FindBy(xpath = "//a[@href='/en-gb/password-reset/']")
    WebElement forgotterMyPassword;


    public void clickOnLinkForgottenPassword() {
        forgotterMyPassword.click();
    }
}
