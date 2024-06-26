package automationexersice.tests;

import automationexersisice.pages.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static automationexersisice.pages.BasePage.sleep;

public class ProductsTest extends BaseTest {
    @Test(description = "Test Case 12: Add Products in Cart",groups = "loggedInState")
    public void verifyAddProductsInCart() {
                                 //Home Page
        SoftAssert softAssertion = new SoftAssert();
        HomePage homePage = new HomePage();
        homePage.clickOnProductMenu();

        sleep(10);
        ProductsPage productPage = new ProductsPage();
        productPage.getTitleOfProuctsPage();
        softAssertion.assertEquals(productPage.getTitleOfProuctsPage(),"Automation Exercise - All Products","The Products page doesnt open");

        productPage.scrollToProduct(500);

        for (int i=0; i<=1;i++) {
            productPage.addDesireProductToCard(i);
            softAssertion.assertTrue(productPage.isAddedToCartWindowsIsOpened(10), "The added window isnot opened after 10 second of waiting for" + i + " products");
            productPage.clickContinue();
        }
        productPage.addDesireProductToCard(2);
        softAssertion.assertTrue(productPage.isAddedToCartWindowsIsOpened(10), "The added window isnot opened after 10 second of waiting for");
        productPage.clickViewCart();//transfer to chart trow View Cart text button on the modal

        sleep(10);
        //productPage.clickOnCartMenu(); //transfer

        CartPage cartPage = new CartPage();

        cartPage.getTitleOfCartPage();
        softAssertion.assertEquals(cartPage.getTitleOfCartPage(),"Automation Exercise - Checkout","The Cart page doesnt open");

        cartPage.getQuantityProductsInCart();
        softAssertion.assertEquals(cartPage.getQuantityProductsInCart(),3,"The both products are not added to Cart");

        softAssertion.assertTrue(cartPage.productDisplayedByIndex(0),"The product doesnt display");
        softAssertion.assertTrue(cartPage.productDisplayedByIndex(1),"The product doesnt display");
        softAssertion.assertTrue(cartPage.productDisplayedByIndex(2),"The product doesnt display");

        //cartPage.getAllProductsText();
        //cartPage.getProductTextByIndex(0);

        softAssertion.assertEquals(cartPage.getNameProductTextByIndex(0),"Blue Top","The name of the product doesnt match");
        softAssertion.assertEquals(cartPage.getDescriptionProductTextByIndex(0),"Women > Tops","The description of the product doesnt match");
        softAssertion.assertEquals(cartPage.getPriceProductTextByIndex(0),"Rs. 500","The price of the product doesnt match");
        softAssertion.assertEquals(cartPage.getCountAddedProductTextByIndex(0),"1","The quantity of the product doesnt match");
        softAssertion.assertEquals(cartPage.getTotalPriceProductTextByIndex(0),"Rs. 500","The total price of the product doesnt match");


        softAssertion.assertEquals(cartPage.getNameProductTextByIndex(1),"Men Tshirt","The name of the product doesnt match");
        softAssertion.assertEquals(cartPage.getDescriptionProductTextByIndex(1),"Men > Tshirts","The description of the product doesnt match");
        softAssertion.assertEquals(cartPage.getPriceProductTextByIndex(1),"Rs. 400","The price of the product doesnt match");
        softAssertion.assertEquals(cartPage.getCountAddedProductTextByIndex(1),"1","The quantity of the product doesnt match");
        softAssertion.assertEquals(cartPage.getTotalPriceProductTextByIndex(1),"Rs. 400","The total price of the product doesnt match");

        softAssertion.assertAll();

    }

    @Test(description = "Test Case 17: Remove Products From Cart",groups = "loggedInState")
    public void verifyDeletingProductFromCart() {
                              //Home Page
        SoftAssert softAssertion = new SoftAssert();
        HomePage homePage = new HomePage();
        homePage.clickOnProductMenu();

        sleep(10);
        ProductsPage productPage = new ProductsPage();
        productPage.scrollToProduct(500);

        for (int i=0; i<=1;i++) {
            productPage.addDesireProductToCard(i);
            softAssertion.assertTrue(productPage.isAddedToCartWindowsIsOpened(10), "The added window isnot opened after 10 second of waiting for" + i + " products");
            productPage.clickContinue();
        }

        sleep(10);
        productPage.clickOnCartMenu();

        CartPage cartPage = new CartPage();

        cartPage.getQuantityProductsInCart();
        softAssertion.assertEquals(cartPage.getQuantityProductsInCart(),2,"The both products are not added to Cart");

        softAssertion.assertTrue(cartPage.productDisplayedByIndex(0),"The product doesnt display");
        softAssertion.assertTrue(cartPage.productDisplayedByIndex(1),"The product doesnt display");

        cartPage.deleteProductFromCard(0);
        sleep(10);

        cartPage.getQuantityProductsInCart();
        softAssertion.assertEquals(cartPage.getQuantityProductsInCart(),1,"The both products are not added to Cart");


        softAssertion.assertAll();

    }

    @Test(description = "Test Case 17.1: Remove All Products From Cart",groups = "loggedInState")
    public void verifyDeletingAllProductFromCart() {
        //Home Page
        SoftAssert softAssertion = new SoftAssert();
        HomePage homePage = new HomePage();
        homePage.clickOnProductMenu();

        sleep(10);
        ProductsPage productPage = new ProductsPage();
        productPage.scrollToProduct(500);

        for (int i=0; i<=1;i++) {
            productPage.addDesireProductToCard(i);
            softAssertion.assertTrue(productPage.isAddedToCartWindowsIsOpened(10), "The added window isnot opened after 10 second of waiting for" + i + " products");
            productPage.clickContinue();
        }

        sleep(10);
        productPage.clickOnCartMenu();

        CartPage cartPage = new CartPage();

        cartPage.getQuantityProductsInCart();
        softAssertion.assertEquals(cartPage.getQuantityProductsInCart(),2,"The both products are not added to Cart");

        softAssertion.assertTrue(cartPage.productDisplayedByIndex(0),"The product doesnt display");
        softAssertion.assertTrue(cartPage.productDisplayedByIndex(1),"The product doesnt display");

        cartPage.deleteAllProductsFromCart();
        sleep(10);

        cartPage.getQuantityProductsInCart();
        softAssertion.assertEquals(cartPage.getQuantityProductsInCart(),0,"The both products are not added to Cart");

        cartPage.emptyCartTextDisplayed(10);
        softAssertion.assertTrue(cartPage.emptyCartTextDisplayed(10),"The empty text is not displayed");

        cartPage.getEmptyText();
        softAssertion.assertEquals(cartPage.getEmptyText(),"Cart is empty! Click here to buy products.","The empty text doesnt match the expected result");

        cartPage.transferProductsPage();


        softAssertion.assertAll();

    }

    @Test(description = "Test Case 18: View Category Products",groups = "loggedInState")
    public void verifyCategoryProducts() {
        //Home Page
        SoftAssert softAssertion = new SoftAssert();
        HomePage homePage = new HomePage();
        homePage.clickOnProductMenu();

        sleep(10);
        ProductsPage productPage = new ProductsPage();
        productPage.getTitleOfProuctsPage();
        softAssertion.assertEquals(productPage.getTitleOfProuctsPage(), "Automation Exercise - All Products", "The Products page doesnt open");

        softAssertion.assertTrue(productPage.getCategoryTitleIsDisplayed(), "The title'Category' doesnt display");
        softAssertion.assertEquals(productPage.getCategoryTitleText(), "CATEGORY", "The title of the Category is wrong");

        softAssertion.assertTrue(productPage.getCategoryIsDisplayed(0), "The category 'Women' doesnt display");
        softAssertion.assertEquals(productPage.getCategoryNameText(0), "WOMEN", "The name of the category doesnt match");

        productPage.clickOnCategoryType(0);

        softAssertion.assertTrue(productPage.getProductIsDisplayed(0), "The product 'DRESS' doesnt display");
        softAssertion.assertEquals(productPage.getProductText(0), "DRESS", "The name product doesnt match");

        productPage.clickOnProductType(0);

        sleep(10);
        DressProductPage dressPage = new DressProductPage();
        dressPage.getTitleOfDressPage();

        softAssertion.assertEquals(dressPage.getTitleOfDressPage(), "Automation Exercise - Dress Products", "The product type page 'Dress Products' doesnt open");


        softAssertion.assertTrue(productPage.getCategoryIsDisplayed(1), "The category 'MEN' doesnt display");
        softAssertion.assertEquals(productPage.getCategoryNameText(1), "MEN", "The name of the category doesnt match");

        productPage.clickOnCategoryType(1);

        softAssertion.assertTrue(productPage.getProductIsDisplayed(1), "The product 'JEANS' doesnt display");
        softAssertion.assertEquals(productPage.getProductText(1), "JEANS", "The name product doesnt match");

        productPage.clickOnProductType(4);

        sleep(10);
        JeansProductPage jeansPage = new JeansProductPage();
        jeansPage.getTitleOfJeansPage();

        softAssertion.assertEquals(jeansPage.getTitleOfJeansPage(), "Automation Exercise - Jeans Products", "The product type page 'Jeans Products' doesnt open");





        softAssertion.assertAll();






    }






}