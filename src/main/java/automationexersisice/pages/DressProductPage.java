package automationexersisice.pages;

import org.openqa.selenium.WebDriver;

public class DressProductPage extends CommonElement{

    public DressProductPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleOfProductTypePage(){
        return getPageTitle();
    }

}
