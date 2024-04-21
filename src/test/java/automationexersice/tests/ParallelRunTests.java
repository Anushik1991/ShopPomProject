package automationexersice.tests;

import automationexersisice.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static automationexersice.object.UsersMockData.getCorrectUserData;
import static automationexersice.object.UsersMockData.getIncorrectCorrectUserData;

public class ParallelRunTests {
    @Test(description = "Test Case 2: Login User with correct email and password")
    public void verifyLogin(){

        SoftAssert softAssertion = new SoftAssert();
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();

        softAssertion.assertEquals(loginPage.getLoginPageTitle(),"Automation Exercise - Signup / Login","Login/Signup page title verification failed");
        softAssertion.assertEquals(loginPage.getLoginText(),"Login to your account","Login title verification failed");

        loginPage.typeLogin(getCorrectUserData().getEmail()); //used the mockdata
        loginPage.typePassword(getCorrectUserData().getPassword());
        loginPage.clickOnLogin();


        softAssertion.assertAll();

    }

    @Test (description = "Test Case 3: Login User with incorrect email and passwordd")
    public void verifyLoginNegativ(){ //написать тест для проверки ерора

        SoftAssert softAssertion = new SoftAssert();
        LoginPage loginPage = new LoginPage();
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
    public void verifyLoginToLogout(String username, String password) {

        SoftAssert softAssertion = new SoftAssert();
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();

        softAssertion.assertEquals(loginPage.getLoginPageTitle(), "Automation Exercise - Signup / Login", "Login/Signup page title verification failed");
        softAssertion.assertEquals(loginPage.getLoginText(), "Login to your account", "Login title verification failed");

        loginPage.typeLogin(username);
        loginPage.typePassword(password);
        loginPage.clickOnLogin();

        //CommonElement commonPage = new CommonElement(driver);

        loginPage.clickOnLogoutMenu();

        softAssertion.assertAll();


    }


}
