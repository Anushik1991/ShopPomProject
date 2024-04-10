package automationexersisice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class BasePage { //common functionality for all pages
    private WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    protected void openPage(String url){
        driver.get(url);
    }
    protected WebElement getElement(By locator){
        return driver.findElement(locator);
    }
    protected void clickOnElement(By locator){
        getElement(locator).click();
    }
    protected void sendKeysOfData(By locator, String text){
        getElement(locator).sendKeys(text);
    }
    protected String getPageTitle(){
       return driver.getTitle();
    }
    public String getElementText(By locator){
        return getElement(locator).getText();
    }
    protected boolean elementDisplayed(By locator){
       return getElement(locator).isDisplayed();
    }
    protected boolean isElementSelected(By locator){
        return getElement(locator).isSelected();
    }
    public void selectCheckbox(By locator) {
        //прожимается, только если цель теста не соответствует текущему состоянию
        if(!isElementSelected(locator)) {
            getElement(locator).click();
        }
    }
    protected void selectElementByText(By locator,String text){
        Select selectElement = new Select(getElement(locator));
        selectElement.selectByVisibleText(text);
    }
    protected void selectElementByIndex(By locator,int index){
        Select selectElement = new Select(getElement(locator));
        selectElement.selectByIndex(index);
    }
    protected void selectElementByIndex(By locator,String value){
        Select selectElement = new Select(getElement(locator));
        selectElement.selectByValue(value);
    }

    public void scroll(WebDriver driver, int pixel) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript(String.format("window.scrollBy(0,%s)",pixel));
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
    protected boolean isElementAvailable(By locator){ // Element is Dom or not

        List<WebElement> elements = driver.findElements(locator);
        if(elements.isEmpty()) {
            return false;
        } else return true;

    }



}
