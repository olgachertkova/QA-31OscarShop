package pages;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends PageBase {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public int elementsCount() {
        List<WebElement> elements = driver.findElements(By.xpath("//h3"));
        System.out.println("Number of items-->" + elements.size());
        return elements.size();
    }

    public boolean elementCountCheck(int elementsCount) {
        return elementsCount > 0;
    }

    public boolean itemValueCheck(String item) {
        List<WebElement> elements = driver.findElements(By.xpath("//h3"));
        System.out.println(elements.size());
        Iterator var3 = elements.iterator();

        String eleementText;
        do {
            if (!var3.hasNext()) {
                return false;
            }

            WebElement el = (WebElement)var3.next();
            eleementText = el.getText();
        } while(!eleementText.equalsIgnoreCase(item));

        return true;
    }
}
