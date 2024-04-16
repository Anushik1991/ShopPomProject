package automationexersisice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends CommonElement {

                                      //Common Locator Products
    private final By PRODUCTS_TITLE = By.xpath("(//h2[@class='title text-center']");
    private final By PRODUCTS_LIST = By.cssSelector(".single-products");
    private final By OVERLAY_ADD_TO_CART = By.cssSelector(".overlay-content a[class*='add-to-cart']");
    private final By MODAL = By.id("cartModal");
    private final By MODAL_TITLE = By.xpath("//h4[@class='modal-title w-100']");
    private final By MODAL_TEXT = By.xpath("//p[@class='text-center']");
    private final By MODAL_VIEW_CART = By.xpath("//a[@href='/view_cart']/u");
    private final By CONTINUE_BUTTON_MODAL_DISMISS = By.cssSelector("button[data-dismiss=modal]");

                                           //Product 1
    private final By PRODUCT_NUMBER1 = By.xpath("//*[@class='features_items']/div[@class='col-sm-4'][1]");
    private final By PRODUCT_NAME = By.xpath("//*[@class='overlay-content']/p[contains(text(),'Blue Top')]");
    private final By ADD_TO_CART = By.xpath("//*[@class='overlay-content']/a[@data-product-id='1']");
    private final By PRODUCT_DETAILS = By.cssSelector("a[href='/product_details/1']");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleOfProuctsPage(){
        return getPageTitle();
        //System.out.println(getPageTitle());
    }
    public void scrollToProduct(int count) {
        scroll(count);
    }

    public void addDesireProductToCard(int index){
        hoverOnElement(getElementFromList(PRODUCTS_LIST,index));
        clickOnClickable(getElementFromList(OVERLAY_ADD_TO_CART,index), 10);
    }

    public boolean isAddedToCartWindowsIsOpened(int duration) {
        return isElementDisplayed(MODAL,duration);
    }

    public void clickContinue(){
        waitForElementBecomeClickable(CONTINUE_BUTTON_MODAL_DISMISS,10);
        clickOnElement(CONTINUE_BUTTON_MODAL_DISMISS);
    }

    public void clickViewCart(){
        waitForElementBecomeClickable(MODAL_VIEW_CART,10);
        clickOnElement(MODAL_VIEW_CART);
    }






}
