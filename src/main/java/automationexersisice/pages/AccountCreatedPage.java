package automationexersisice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static automationexersisice.setup.SeleniumWebdriver.getWebDriver;

public class AccountCreatedPage extends CommonElement  {

    private final By ACCOUNT_CREATED_TITLE = By.cssSelector("[data-qa=account-created]");
    private final By CONTINUE_BUTTON = By.xpath("//a[@data-qa='continue-button']");

    public AccountCreatedPage() {
        super(getWebDriver());
    }


    public String getAccountCreatedText(){
        return getElementText(ACCOUNT_CREATED_TITLE);
    }

    public void clickOnContinue() {
        clickOnElement(CONTINUE_BUTTON);
    }
    public boolean continueButtonDisplayed(){
        return isElementAvailable(CONTINUE_BUTTON);
    }








}
