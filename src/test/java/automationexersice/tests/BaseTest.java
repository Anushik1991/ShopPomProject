package automationexersice.tests;

import automationexersisice.pages.LoginPage;
import automationexersisice.setup.SeleniumWebdriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static automationexersisice.setup.ConfigurationManager.PASSWORD;
import static automationexersisice.setup.ConfigurationManager.USERNAME;

public class BaseTest {
    WebDriver driver;
    //При использовании параметизации используется testng, optional = default parametr.
    // Если в файле testNG.xml остутствует строка <parameter name="browser" value="chrome"></parameter>
    // то осуществится run со значением @Optional("chrome")
    @Parameters({"browser"})
    @BeforeMethod
    public void openBrowser(@Optional("chrome")  String browser){
        driver = SeleniumWebdriver.getWebDriver(browser);
        driver.manage().window().maximize();
    }

    @BeforeMethod (onlyForGroups = "loggedInState", dependsOnMethods = "openBrowser" )
    public void loggedInStateSetup(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.typeLogin(USERNAME); //use the constants from config file
        loginPage.typePassword(PASSWORD);//use the constants from config file
        loginPage.clickOnLogin();
    }










}
