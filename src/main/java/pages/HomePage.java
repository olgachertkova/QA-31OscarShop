package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(.,'Oscar')]")
    WebElement homePageLink;
    @FindBy(id = "login_link")
    WebElement loginAndRegisterButton;
    //  @FindBy(xpath = "//div[@class='alertinner wicon']")
    @FindBy(css = ".alertinner.wicon")
    WebElement registerSuccessMessage;
    @FindBy(css = "select[name='language']")
    WebElement langSelector;
    @FindBy(css = "button[class='btn btn-default']")
    WebElement goButton;
    @FindBy(css = ".basket-mini a.btn.btn-default")
    WebElement basketButton;
    @FindBy(xpath = "//input[@id='id_login-username']")
    WebElement emailField;
    @FindBy(xpath = "//input[@id='id_login-password']")
    WebElement passwordField;
    @FindBy(css = "button[value='Log In']")
    WebElement loginButton;
    @FindBy(id = "\"register_form")
    WebElement registerForm;


    public boolean homeLinkIsVisible() {
        return homePageLink.isDisplayed();
    }

    public void clickToLoginAndRegisterButton() {
        loginAndRegisterButton.click();
    }

    public boolean registerSuccessMessageIsDisplayed() {
        waitUntilElementVisible(registerSuccessMessage, 30);
        return registerSuccessMessage.isDisplayed();
    }

    public void selectLanguage(String lang) {
        selectInDropDownByValue(langSelector, lang);
    }

    public void clickOnGoButton() {
        goButton.click();
    }

    public String getTextFromGoButton() {
        System.out.println(goButton.getText());
        return goButton.getText();
    }

    public String getTextFromBasketButton() {
        System.out.println(basketButton.getText());
        return basketButton.getText();
    }
    public void login(String email, String password){
        clickToLoginAndRegisterButton();
        //     Assert.assertTrue(loginAndRegisterPage.loginAndRegistrationFormIsOpened());
        inputText(emailField,email);
        inputText(passwordField,password);
        click(loginButton);
        Assert.assertTrue(driver.findElement(By.xpath("//a[@id='logout_link']")).isEnabled());
    }
}
