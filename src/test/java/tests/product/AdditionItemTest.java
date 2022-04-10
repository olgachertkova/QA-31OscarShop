package tests.product;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.TestBase;

public class AdditionItemTest extends TestBase {

    @Test
public void aDTestUnLoggedUser(){
        Assert.assertTrue(new HomePage(driver)
                .clickProduct()
                .addItem().isElementPresent());
    }
}
