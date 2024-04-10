package automationexersice;

import automationexersisice.pages.LoginPage;
import automationexersisice.pages.LoginPage1;
import automationexersisice.pages.SignUpPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SignUpFlowTest extends BaseTest {

    @Test (description= "Test Case 1: Register User with valid data")
    public void verifySignUpPositivCase(){
                                  //Login page
        SoftAssert softAssertion = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();

        softAssertion.assertEquals(loginPage.getLoginPageTitle(),"Automation Exercise - Signup / Login","Login/Signup page title verification failed");
        softAssertion.assertEquals(loginPage.getSignText(),"New User Signup!","Sign Up title verification failed");

        loginPage.typeUsername("Anna");
        loginPage.typeEmail("anna23452@gmail.com");

        loginPage.clickOnSignUp();
        softAssertion.assertFalse(loginPage.signUpButtonDisplayed(),"The test is failed");

                                          //Sign Up Page
        SignUpPage signupPage = new SignUpPage(driver);

        softAssertion.assertEquals(signupPage.getSignUpPageTitle(),"Automation Exercise - Signup","Account info page title verification failed");
        softAssertion.assertEquals(signupPage.getAccountInfoText(),"ENTER ACCOUNT INFORMATION","Account info title verification failed");

        signupPage.clickOnGender();
        softAssertion.assertTrue(signupPage.genderChecked(),"The gender radio button is not checked. The test is failed");
        signupPage.typePassword("Anushik1991");

        signupPage.daySelect("31");
        signupPage.monthsSelect("November");
        signupPage.yearsSelect("1992");

        softAssertion.assertFalse(signupPage.newsletterChecked(),"Newsletter checkbox is already checked. The test is failed");
        signupPage.setNewsletterCheckbox();
        softAssertion.assertTrue(signupPage.newsletterChecked(),"Newsletter checkbox is not checked. The test is failed");

        softAssertion.assertFalse(signupPage.offersChecked(),"Offers checkbox is already checked. The test is failed");
        signupPage.setOffersCheckbox();
        softAssertion.assertTrue(signupPage.offersChecked(),"Offers checkbox is not checked. The test is failed");

        softAssertion.assertEquals(signupPage.getAddressInfoText(),"ADDRESS INFORMATION","Address info title verification failed");

        signupPage.scrollAfterAddressInfoText(driver,500);

        signupPage.typeFirstName("Anush");
        signupPage.typeLastName("Akopyan");
        signupPage.typeCompanyName("IT company");
        signupPage.typeAddress1("Komitas 1");
        signupPage.setCountrySelect("Singapore");
        signupPage.typeState("Yerevan");
        signupPage.typeCity("Yerevan");
        signupPage.typeZip("1234");
        signupPage.typeTelNumber("091356701");

        signupPage.clickOnCreateAccountButton();



        softAssertion.assertAll();




    }

    @Test (description= "Test Case 2: Register User with no valid data",dataProvider = "loginData",dataProviderClass = automationexersice.data.DataInput.class)
    public void verifySignUpNegativCase(String name, String email, String text){

                               //Login page
        SoftAssert softAssertion = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();

        softAssertion.assertEquals(loginPage.getLoginPageTitle(),"Automation Exercise - Signup / Login","Login/Signup page title verification failed");
        softAssertion.assertEquals(loginPage.getSignText(),"New User Signup!","Sign Up title verification failed");
        loginPage.typeUsername(name);
        loginPage.typeEmail(email);
        loginPage.clickOnSignUp();

        //softAssertion.assertTrue(loginPage.getSignUpButton(),"Sign Up title verification failed");



        softAssertion.assertAll();

    }

    @Test (dataProvider = "loginData",dataProviderClass = automationexersice.data.DataInput.class)
    public void verifySignUp1(String name, String email,String text){
        SoftAssert softAssertion =new SoftAssert();
        LoginPage1 loginPage = new LoginPage1(driver);
        loginPage.openLoginPage().typeUsername(name).typeEmail(email).clickOnSignUp();
        //softAssertion.assertEquals("error","The actual result doesnt match expected result");

    }






}










