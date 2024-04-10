package automationexersice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        //WebDriverManager.chromedriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }










}
