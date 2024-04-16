package automationexersisice.pages;

import org.openqa.selenium.WebDriver;


public class HomePage extends CommonElement {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(){
        openPage("https://automationexercise.com/");
    }





}
