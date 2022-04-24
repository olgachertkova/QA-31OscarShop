package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='alertinner wicon']")
    WebElement welcomeText;

    public boolean islogged(){
        waitUntilElementVisible(welcomeText,10);
        return welcomeText.isDisplayed();
    }
}
