package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class PageBase {
    protected WebDriver driver;
    int timeWaitElement = 30;

    public PageBase(WebDriver driver){
        this.driver = driver;
    }

    public void should(WebElement element, int time) {
        new WebDriverWait(driver, time)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void uploadFile(WebElement element, String filePath){
        waitUntilElementClickable(element, timeWaitElement);
        inputText(element, filePath);
    }

    public void click(WebElement element){
        waitUntilElementClickable(element, timeWaitElement);
        element.click();
    }

    public void checkIn(WebElement element){
        waitUntilElementVisible(element, timeWaitElement);
        if(!element.isSelected()){
            element.click();
        }
    }

    public void inputText(WebElement element, String text){
        waitUntilElementClickable(element, timeWaitElement);
        element.click();
        element.clear();
        element.sendKeys(text);
    }


    public void selectInDropDownByValue(WebElement element, String value){
        waitUntilElementClickable(element, timeWaitElement);
        Select languageSelect = new Select(element);
        languageSelect.selectByValue(value);
    }

    void waitUntilElementClickable(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void waitUntilElementVisible (WebElement element, int time){
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    void waitUntilElementInVisible (WebElement element, int time){
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    void waitUntilAllElementsVisible (List<WebElement> elements, int time){
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
