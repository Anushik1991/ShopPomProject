package automationexersisice.pages;

import org.openqa.selenium.WebDriver;

public class JeansProductPage extends CommonElement {

    public JeansProductPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleOfJeansPage(){
        return getPageTitle();
    }

}
