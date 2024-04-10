package automationexersisice.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends CommonElement  {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
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

                                    //SIGN UP methods

    public void openLoginPage(){
        openPage("https://automationexercise.com/login");
    }
    public String getLoginPageTitle(){
        return getPageTitle();
    }
    public String getSignText(){
        return getElementText(SIGNUP_TITLE);
    }
    public void typeUsername(String name) {
        sendKeysOfData(NAME,name);
    }
    public void typeEmail(String email) {
        sendKeysOfData(EMAIL_ADDRESS,email);
    }
    public void clickOnSignUp() {
        clickOnElement(SIGNUP_BUTTON);
    }
    public String getSignUpButtonText(){
        return getElementText(SIGNUP_BUTTON);
    }
    public boolean signUpButtonDisplayed(){
        return isElementAvailable(SIGNUP_BUTTON);
    }




                              //Login_method

    public String getLoginText(){
        return getElementText(LOGIN_TITLE);
    }
    public void typeLogin(String login){
        sendKeysOfData(LOGIN,login);
    }
    public void typePassword(String password){
        sendKeysOfData(PASSWORD,password);
    }
    public void clickOnLogin() {
        clickOnElement(LOGIN_BUTTON);
    }





}