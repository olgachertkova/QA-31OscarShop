package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

//    WebElement homePageLink = driver.findElement(By.xpath("//a[contains(.,'Oscar')]"));
//    WebElement loginAndRegisterButton = driver.findElement(By.id("login_link"));

    public boolean homeLinkIsVisible() {
        WebElement homePageLink = driver.findElement(By.xpath("//a[contains(.,'Oscar')]"));
        return homePageLink.isDisplayed();
    }

    public void clickToLoginAndRegisterButton() {
        WebElement loginAndRegisterButton = driver.findElement(By.id("login_link"));
//        click(loginAndRegisterButton);
        loginAndRegisterButton.click();
    }

    public boolean registerSuccessMessageIsDisplayed() {
        //return (driver.findElement(By.xpath("//*[contains(.,'Thanks')]")).isDisplayed());
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='alertinner wicon']"))));
        return driver.findElement(By.xpath("//div[@class='alertinner wicon']")).getText().contains("Thanks");
    }
}
