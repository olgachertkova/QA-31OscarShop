package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageBase{

    @FindBy(xpath ="//form[@action='/en-gb/basket/add/207/']")
    WebElement item_207;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage addItem(){
        driver.findElement(By.xpath("//form[@action='/en-gb/basket/add/207/']")).click();
        return this;
    }
    public boolean isElementPresent(){
        if (driver.findElement(By.xpath("//div[@class='alertinner '][contains(.,'has been added to your basket.')]")).isDisplayed()){
            return true;
        }
        else {
            return false;
        }

    }

    ////div[contains(.,'has been added to your basket.')]
}
