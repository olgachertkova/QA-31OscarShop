package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginAndRegisterPage extends PageBase{
    public LoginAndRegisterPage(WebDriver driver) {
        super(driver);
    }

    WebElement registerForm = driver.findElement(By.id("register_form"));

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
}
