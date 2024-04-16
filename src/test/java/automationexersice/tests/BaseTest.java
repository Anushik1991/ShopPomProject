package automationexersice.tests;

import automationexersisice.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod (onlyForGroups = "loggedInState", dependsOnMethods = "openBrowser" )
    public void loggedInStateSetup(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.typeLogin("anush2001@gmail.com");
        loginPage.typePassword("Anush1991");
        loginPage.clickOnLogin();
    }










}
