package automationexersisice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static automationexersisice.setup.SeleniumWebdriver.getWebDriver;

public class CartPage extends CommonElement{

    private final By ALL_PRODUCTS_IN_CART = By.xpath("//tbody");
    private final By PRODUCT_IN_CART = By.xpath("//tbody/tr");
    private final By PICTURE_PRODUCT_IN_CART = By.xpath("//td[@class='cart_product']");
    private final By NAME_PRODUCT_IN_CART = By.xpath("//td[@class='cart_description']/h4");
    private final By DESCRIPTION_PRODUCTS_IN_CART = By.xpath("//td[@class='cart_description']/p");
    private final By PRICE_PRODUCTS_IN_CART = By.xpath("//td[@class='cart_price']");
    private final By QUANTITY_PRODUCTS_IN_CART = By.xpath("//td[@class='cart_quantity']");
    private final By TOTAL_PRICE_PRODUCTS_IN_CART = By.xpath("//td[@class='cart_total']");
    private final By DELETE_PRODUCT_FROM_CART = By.xpath("//*[@class='cart_quantity_delete']");
    private final By EMPTY_CART = By.xpath("//*[@id='empty_cart']/p");
    private final By TRANSFER_TO_PRODUCTS_FROM_EMPTY_CART = By.xpath("//*[@id='empty_cart']/p/a");

    public CartPage() {
        super();
    }

    public String getTitleOfCartPage(){
        return getPageTitle();
    }
    public void getAllProductsText(){
        getElementText(ALL_PRODUCTS_IN_CART);
        System.out.println(getElementText(ALL_PRODUCTS_IN_CART));
    }

    public int getQuantityProductsInCart(){
           return getQuantity(PRODUCT_IN_CART);
        //System.out.println(getQuantity(PRODUCTS_IN_CART1));
    }

    public boolean productDisplayedByIndex(int index){
        return isElementDisplayedByIndex(PRODUCT_IN_CART,index);
    }

    public void getProductTextByIndex(int index) {
        getElementTextByIndex(PRODUCT_IN_CART,index);
        System.out.println(getElementTextByIndex(PRODUCT_IN_CART, index));
    }

    public String getNameProductTextByIndex(int index) {
        return getElementTextByIndex(NAME_PRODUCT_IN_CART,index);
        //System.out.println(getElementTextByIndex(NAME_PRODUCT_IN_CART, index));
    }

    public String getDescriptionProductTextByIndex(int index) {
        return getElementTextByIndex(DESCRIPTION_PRODUCTS_IN_CART,index);
        //System.out.println(getElementTextByIndex(DESCRIPTION_PRODUCTS_IN_CART, index));
    }

    public String getPriceProductTextByIndex(int index) {
        return getElementTextByIndex(PRICE_PRODUCTS_IN_CART,index);
        //System.out.println(getElementTextByIndex(PRICE_PRODUCTS_IN_CART, index));
    }

    public String getCountAddedProductTextByIndex(int index) {
        return getElementTextByIndex(QUANTITY_PRODUCTS_IN_CART,index);
        //System.out.println(getElementTextByIndex(QUANTITY_PRODUCTS_IN_CART, index));
    }

    public String getTotalPriceProductTextByIndex(int index) {
        return getElementTextByIndex(TOTAL_PRICE_PRODUCTS_IN_CART,index);
        //System.out.println(getElementTextByIndex(TOTAL_PRICE_PRODUCTS_IN_CART, index));
    }

    public void deleteProductFromCard(int index){
        hoverOnElement(getElementFromList(DELETE_PRODUCT_FROM_CART,index));
        clickOnElement(getElementFromList(DELETE_PRODUCT_FROM_CART,index));
    }

    public void deleteAllProductsFromCart() {
        for (int i = getQuantity(DELETE_PRODUCT_FROM_CART) - 1; i >= 0; i--) {
            deleteProductFromCard(i);
        }
    }

    public boolean emptyCartTextDisplayed(int duration){
        return isElementDisplayed(EMPTY_CART,duration);
    }

    public String getEmptyText(){
        return getElementText(EMPTY_CART);
        //System.out.println(getElementText(EMPTY_CART));
    }

    public void transferProductsPage(){
        clickOnElement(TRANSFER_TO_PRODUCTS_FROM_EMPTY_CART);
    }







}
