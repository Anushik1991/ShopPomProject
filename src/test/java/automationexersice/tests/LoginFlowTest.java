package automationexersice.tests;

import automationexersisice.pages.CommonElement;
import automationexersisice.pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static automationexersice.object.UsersMockData.getCorrectUserData;
import static automationexersice.object.UsersMockData.getIncorrectCorrectUserData;

public class LoginFlowTest extends BaseTest {

    @Test (description = "Test Case 2: Login User with correct email and password")
    public void verifyLoginPositivCase(){

        SoftAssert softAssertion = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();

        softAssertion.assertEquals(loginPage.getLoginPageTitle(),"Automation Exercise - Signup / Login","Login/Signup page title verification failed");
        softAssertion.assertEquals(loginPage.getLoginText(),"Login to your account","Login title verification failed");

        loginPage.typeLogin(getCorrectUserData().getEmail());
        loginPage.typePassword(getCorrectUserData().getPassword());
        loginPage.clickOnLogin();


        softAssertion.assertAll();

    }

    @Test (description = "Test Case 3: Login User with incorrect email and passwordd")
    public void verifyLoginNegativCase(){ //написать тест для проверки ерора

        SoftAssert softAssertion = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();

        softAssertion.assertEquals(loginPage.getLoginPageTitle(),"Automation Exercise - Signup / Login","Login/Signup page title verification failed");
        softAssertion.assertEquals(loginPage.getLoginText(),"Login to your account","Login title verification failed");

        loginPage.typeLogin(getIncorrectCorrectUserData().getEmail());
        loginPage.typePassword(getCorrectUserData().getPassword());
        loginPage.clickOnLogin();

        softAssertion.assertEquals(loginPage.getIncorrectLoginDataText(),"Your email or password is incorrect!","The exeption text is wrong");
        softAssertion.assertTrue(loginPage.IncorrectLoginDataDisplayed(),"The inline error message doesnt display ");

        softAssertion.assertAll();

    }

    @Test (description = "Test Case 4: Logout User")
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
