package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(.,'Oscar')]")
    WebElement homePageLink;
    @FindBy(id = "login_link")
    WebElement loginAndRegisterButton;
    @FindBy(css = ".alertinner.wicon")
    WebElement registerSuccessMessage;
    @FindBy(css = "[name=\"language\"]")
    WebElement langSelector;
    @FindBy(css = "button.btn.btn-default[type=\"submit\"]")
    WebElement goButton;
    @FindBy(css = ".basket-mini a.btn")
    WebElement basketButton;


    public boolean homeLinkIsVisible() {
        return homePageLink.isDisplayed();
    }

    public void clickToLoginAndRegisterButton() {
//        click(loginAndRegisterButton);
        loginAndRegisterButton.click();
    }

    public boolean registerSuccessMessageIsDisplayed() {
        waitUntilElementVisible(registerSuccessMessage, 30);
        return registerSuccessMessage.isDisplayed();
    }

    public void selectLang(String lang) {
        selectInDropDownByValue(langSelector, lang);
    }

    public void clickOnGoButton() {
        goButton.click();
    }

    public String getTextFromGoButton() {
        return goButton.getText();
    }

    public String getTextFromBasketButton() {
        return basketButton.getText();
    }
}
