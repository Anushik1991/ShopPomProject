package automationexersisice.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static automationexersisice.setup.SeleniumWebdriver.getWebDriver;

public class LoginPage1 extends CommonElement  {
                                 //LOGIN
    private final By LOGIN_TITLE = By.cssSelector(".login-form h2");
    private final By LOGIN = By.cssSelector("input[data-qa=login-email]");
    private final By PASSWORD = By.cssSelector("input[data-qa=login-password]");
    private final By LOGIN_BUTTON = By.cssSelector("[action='/login'] button");

                                  //SIGN UP
    private final By SIGNUP_TITLE = By.cssSelector(".signup-form h2");
    private final By NAME = By.cssSelector("input[name='name']");
    private final By EMAIL_ADDRESS = By.cssSelector(".signup-form [name='email']");
    private final By SIGNUP_BUTTON = By.xpath("//button[text()='Signup']");

                                  //SUBSCRIPTION
    private final By SUBSCRIPTION_TITLE = By.cssSelector(".single-widget h2");
    private final By SUB_EMAIL = By.id("susbscribe_email");
    private final By SUSBSCRIBE_BUTTON = By.xpath("//button[@id='subscribe']");

    public LoginPage1() {
        super();
    }


    //SIGN UP methods

    public LoginPage1 openLoginPage(){
        openPage("https://automationexercise.com/login");
        return this;
    }
    public LoginPage1 typeUsername(String name) {
        sendKeysOfData(NAME,name);
        return this;
    }
    public LoginPage1 typeEmail(String email) {
        sendKeysOfData(EMAIL_ADDRESS,email);
        return this;
    }
    public void clickOnSignUp() {
        clickOnElement(SIGNUP_BUTTON);
    }






}
