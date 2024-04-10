package automationexersisice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonElement extends BasePage {

    private final By TEST_CASES_MENU = By.cssSelector("[href='/test_cases']");
    private final By SIGNUP_LOGIN_MENU = By.cssSelector("[href='/contact_us']");
    private final By CONTACT_MENU = By.cssSelector("[href='/contact_us']");
    private final By VIDEO_TUTORIALS_MENU = By.cssSelector("[href='https://www.youtube.com/c/AutomationExercise']");
    private final By API_RESTING_MENU = By.cssSelector("[href='/api_list']");
    private final By PRODUCTS_MENU = By.cssSelector("[href='/products']");
    private final By HOME_MENU = By.cssSelector("[href='/']");
    private final By LOGOUT_MENU = By.cssSelector("[href='/logout']");
    private final By DELETE_MENU = By.cssSelector("[href='/delete_account']");

    public CommonElement(WebDriver driver) {
        super(driver);
    }

    public void clickOnLogoutMenu() {
        clickOnElement(LOGOUT_MENU);
    }

    public void clickOnDeleteMenu() {
        clickOnElement(DELETE_MENU);
    }









}
