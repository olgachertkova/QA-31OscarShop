package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProfilePage extends PageBase{
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h1[normalize-space()='Profile']")
    WebElement profile;
    @FindBy(xpath = "//a[normalize-space()='Change password']")
    WebElement changePassword;

    public boolean profileMessageIsVisible() {
        return profile.isDisplayed();
    }

    public void clickOnChangePasswordButton() {
        changePassword.click();
    }

    public void changePassword() {
        inputText(driver.findElement(By.cssSelector("#id_old_password")), "Durdom2@14");
        inputText(driver.findElement(By.cssSelector("#id_new_password1")),"Durdom2@144" );
        inputText(driver.findElement(By.cssSelector("#id_new_password2")),"Durdom2@144" );
        click(driver.findElement(By.xpath("//button[.='Save']")));

    }

    public boolean passwordUpdates() {
        return driver.findElement(By.xpath("//div[@class='alertinner wicon']")).isDisplayed();
    }
}
