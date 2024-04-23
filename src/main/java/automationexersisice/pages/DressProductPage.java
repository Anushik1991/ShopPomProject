package automationexersisice.pages;

import org.openqa.selenium.WebDriver;

import static automationexersisice.setup.SeleniumWebdriver.getWebDriver;

public class DressProductPage extends CommonElement{

    public DressProductPage() {
        super();
    }

    public String getTitleOfDressPage(){
        return getPageTitle();
    }

}
