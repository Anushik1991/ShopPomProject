package automationexersice.tests;

import automationexersisice.pages.LoginPage;
import automationexersisice.setup.SeleniumWebdriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    public void openBrowser(@Optional("chrome") String browser){
        driver = SeleniumWebdriver.getWebDriver(browser);
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
