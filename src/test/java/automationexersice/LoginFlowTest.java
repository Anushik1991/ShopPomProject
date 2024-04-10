package automationexersice;

import automationexersisice.pages.CommonElement;
import automationexersisice.pages.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginFlowTest extends BaseTest {

    @Test
    public void verifyLoginPositivCase(){

        SoftAssert softAssertion = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();

        softAssertion.assertEquals(loginPage.getLoginPageTitle(),"Automation Exercise - Signup / Login","Login/Signup page title verification failed");
        softAssertion.assertEquals(loginPage.getLoginText(),"Login to your account","Login title verification failed");

        loginPage.typeLogin("anush2001@gmail.com");
        loginPage.typePassword("Anush1991");
        loginPage.clickOnLogin();


        softAssertion.assertAll();

    }



    @Test
    public void verifyLoginToLogout() {

        SoftAssert softAssertion = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();

        softAssertion.assertEquals(loginPage.getLoginPageTitle(), "Automation Exercise - Signup / Login", "Login/Signup page title verification failed");
        softAssertion.assertEquals(loginPage.getLoginText(), "Login to your account", "Login title verification failed");

        loginPage.typeLogin("anush2001@gmail.com");
        loginPage.typePassword("Anush1991");
        loginPage.clickOnLogin();

        CommonElement commonPage = new CommonElement(driver);
        commonPage.clickOnLogoutMenu();

        softAssertion.assertAll();


    }










}
