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

    public void openLoginRegForm() {
        should(loginAndRegisterButton, 20);
        loginAndRegisterButton.click();
    }

    @FindBy(xpath = "//div[contains(text(),'Welcome back')]")
    WebElement massageSuccessLogin;
    public boolean loginSuccessMassageIsDiplayed() {
        //waitUntilElementInVisible(massageSuccessLogin,30);
        return massageSuccessLogin.isDisplayed();

    }

    @FindBy (id = "logout_link")
    WebElement logout;

    public void logOut() {
        waitUntilElementVisible(logout,30);
        logout.click();
    }

    @FindBy (id = "id_q")
    WebElement searchField;
    public void fillFieldSearch(String product) {
        inputText(searchField,product);
    }


    @FindBy (xpath = "//input[@class='btn btn-default']")
    WebElement searchButton;
    public void clickBTNsearch() {
        searchButton.click();
    }

    @FindBy (xpath = "//h1[contains(.,'Products matching ')]")
    WebElement searchResult;
    public boolean searchResultTextIsDisplayed() {
        waitUntilElementVisible(searchResult,30);
        return searchResult.isDisplayed();
    }

    @FindBy (xpath = "//form//p[contains(.,'Found 0 results.')]")
    WebElement formResult;
    public boolean formResultIsDisplayed() {
        return formResult.isDisplayed();
    }







}

