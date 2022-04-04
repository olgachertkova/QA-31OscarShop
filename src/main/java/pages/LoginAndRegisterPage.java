package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginAndRegisterPage extends PageBase{
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
}
