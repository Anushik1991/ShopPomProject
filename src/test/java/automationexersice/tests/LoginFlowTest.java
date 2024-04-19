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

        loginPage.typeLogin(getCorrectUserData().getEmail()); //used the mockdata
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

    @Test (description = "Test Case 4.1: Logout User",dataProvider = "loginDataCSV",dataProviderClass = automationexersice.data.DataInput.class)
    public void verifyLoginToLogoutCSV(String username, String password) {

        SoftAssert softAssertion = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();

        softAssertion.assertEquals(loginPage.getLoginPageTitle(), "Automation Exercise - Signup / Login", "Login/Signup page title verification failed");
        softAssertion.assertEquals(loginPage.getLoginText(), "Login to your account", "Login title verification failed");

        loginPage.typeLogin(username);
        loginPage.typePassword(password);
        loginPage.clickOnLogin();

        CommonElement commonPage = new CommonElement(driver);


        commonPage.clickOnLogoutMenu();

        softAssertion.assertAll();


    }

    @Test (description = "Test Case 4.2: Logout User",dataProvider = "loginDataJSON",dataProviderClass = automationexersice.data.DataInput.class)
    public void verifyLoginToLogoutJson(String username, String password) {

        SoftAssert softAssertion = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();

        softAssertion.assertEquals(loginPage.getLoginPageTitle(), "Automation Exercise - Signup / Login", "Login/Signup page title verification failed");
        softAssertion.assertEquals(loginPage.getLoginText(), "Login to your account", "Login title verification failed");

        loginPage.typeLogin(username);
        loginPage.typePassword(password);
        loginPage.clickOnLogin();

        CommonElement commonPage = new CommonElement(driver);


        commonPage.clickOnLogoutMenu();

        softAssertion.assertAll();


    }








}
