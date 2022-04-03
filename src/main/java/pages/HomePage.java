package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    WebElement homePageLink = driver.findElement(By.xpath("//a[contains(.,'Oscar')]"));
    WebElement loginAndRegisterButton = driver.findElement(By.id("login_link"));

    public boolean homeLinkIsVisible() {
        return homePageLink.isDisplayed();
    }

    public void clickToLoginAndRegisterButton() {
//        click(loginAndRegisterButton);
        loginAndRegisterButton.click();
    }

    public boolean registerSuccessMessageIsDisplayed() {
        return (driver.findElement(By.xpath("//*[contains(.,'Thanks')]")).isDisplayed());
    }
}
