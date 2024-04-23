package automationexersisice.pages;

import org.openqa.selenium.WebDriver;

import static automationexersisice.setup.SeleniumWebdriver.getWebDriver;

public class JeansProductPage extends CommonElement {

    public JeansProductPage() {
        super();
    }

    public String getTitleOfJeansPage(){
        return getPageTitle();
    }

}
