package automationexersisice.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumWebdriver {  //we used for paralleling run
        protected static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();
        public static WebDriver getWebDriver() {
            return threadLocal.get();
        }
        public static void setWebDriver(String browser){
            if (browser.equals("chrome")) {
                WebDriverManager.chromedriver().setup();//?
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-miximized");
                threadLocal.set(new ChromeDriver(options));
            } else if (browser.equals("edge")) {
                WebDriverManager.edgedriver().setup();
                threadLocal.set(new EdgeDriver());
            } else if (browser.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                threadLocal.set(new FirefoxDriver());
            } else {
                System.out.println("you entered invalid browser");
            }
        }

    /*

    public static WebDriver getWebDriver(String browser) { // we get the method when no usinig paralel running
        WebDriver driver = null;
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();//?
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.out.println("you entered invalid browser");

        }
        return driver;
    }

     */




}
