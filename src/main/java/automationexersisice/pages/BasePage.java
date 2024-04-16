package automationexersisice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage { //common functionality for all pages
    private final WebDriver driver;

    private final int timeout = 10;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void openPage(String url) {
        driver.get(url);
    }

    protected WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    protected WebElement getExistingElement(By locator, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        return wait.until(driver1 -> driver1.findElement(locator));
    }

    protected String getPageTitle() {
        return driver.getTitle();
    }

    public String getElementText(By locator) {
        return getElement(locator).getText();
    }

    public String getElementTextByIndex(By locator, int index) {
        return getElementFromList(locator, index).getText();
    }

    protected void clickOnElement(By locator) {
        getElement(locator).click();
    }

    protected void clickOnWebElement(WebElement element) {
        element.click();
    }

    protected void clickOnClickable(WebElement element, int duration){
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
          wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void waitForElementBecomeClickable(By locator, int duration) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void sendKeysOfData(By locator, String text) {
        getElement(locator).sendKeys(text);
    }

    protected boolean isElementDisplayed(By locator, int duration) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(duration));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    protected boolean isElementDisplayedByIndex(By locator, int index) {
        return getElementFromList(locator,index).isDisplayed();
    }


    protected boolean isElementSelected(By locator) {
        return getElement(locator).isSelected();
    }

    public void selectCheckbox(By locator) {
        //прожимается, только если цель теста не соответствует текущему состоянию
        if (!isElementSelected(locator)) {
            getElement(locator).click();
        }
    }

    protected void selectElementByText(By locator, String text) {
        Select selectElement = new Select(getElement(locator));
        selectElement.selectByVisibleText(text);
    }

    protected void selectElementByIndex(By locator, int index) {
        Select selectElement = new Select(getElement(locator));
        selectElement.selectByIndex(index);
    }

    protected void selectElementByValue(By locator, String value) {
        Select selectElement = new Select(getElement(locator));
        selectElement.selectByValue(value);
    }

    public void scroll(int pixel) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(String.format("window.scrollBy(0,%s)", pixel));
    }

    protected void switchToWindowByTitle(WebDriver driver, String title) {

        //String handle = driver.getWindowHandle(); //uniq indetify return
        //System.out.println(handle);

        Set<String> windowHandles = driver.getWindowHandles(); // return all windows
        for (String windowHandle : windowHandles) {
            if (driver.getTitle().equals(title)) {
                break;
            }
            driver.switchTo().window(windowHandle);
        }

    }

    protected boolean isElementAvailable(By locator) { // Element is Dom or not

        List<WebElement> elements = driver.findElements(locator);
        if (elements.isEmpty()) {
            return false;
        } else return true;

    }

    protected List<WebElement> getWebElements(By locator) { // возращает весь лист элементов
        return driver.findElements(locator);
    }

    protected WebElement getElementFromList(By locator, int index) {
        return getWebElements(locator).get(index);
    }

    public int getQuantity(By locator) {
        return getWebElements(locator).size();
    }

    protected void hoverOnElement(WebElement element) {  // hover
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();

    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }




}
