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
    @FindBy(css =  "[name='language']")
    WebElement langSelector;


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
        selectInDropDownByValue(langSelector,lang);
    }

    public void clickOnGo() {
        WebElement element = driver.findElement(By.xpath("//button[normalize-space()='Go']"));
        element.click();
    }

    public String getTextFromGoBtn() {
        WebElement element = driver.findElement(By.xpath("//button[normalize-space()='Go']"));
        return element.getText() ;
    }
}
