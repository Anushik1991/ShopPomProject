package automationexersisice.pages;


import org.openqa.selenium.WebDriver;

import static automationexersisice.setup.SeleniumWebdriver.getWebDriver;

public class HomePage extends CommonElement {

    public HomePage() {
        super(getWebDriver());
    }

    public void openHomePage(){
        openPage("https://automationexercise.com/");
    }





}
