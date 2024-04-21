package automationexersisice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static automationexersisice.setup.SeleniumWebdriver.getWebDriver;

public class SignUpPage extends CommonElement {

    private final By ACCOUNT_INFO_TITLE = By.xpath("(//h2[@class='title text-center']/b)[1]");
    private final By CHECKBOX_MR = By.xpath("//input[@id='id_gender1']");
    private final By CHECKBOX_MRS = By.xpath("//input[@id='id_gender2']");
    private final By PASSWORD_REG = By.xpath("//input[@id='password']");
    private final By DAY_SELECT = By.id("days");
    private final By MONTHS_SELECT = By.id("months");
    private final By YEARS_SELECT = By.id("years");
    private final By NEWSLETTER_CHECKBOX_INPUT = By.name("newsletter");
    private final By NEWSLETTER_CHECKBOX_LABEL = By.cssSelector("[for='newsletter']");
    private final By OFFERS_CHECKBOX= By.cssSelector("[for='optin']");
    private final By OFFERS_CHECKBOX_INPUT= By.name("optin");
    private final By ADDRESS_INFO_TITLE = By.xpath("(//h2[@class='title text-center']/b)[2]");
    private final By NAME_INPUT = By.id("first_name");
    private final By LASTNAME_INPUT = By.id("last_name");
    private final By COMPANY_INPUT = By.id("company");
    private final By ADDRESS1_INPUT = By.id("address1");
    private final By COUNTRY_SELECT = By.id("country");
    private final By STATE_INPUT = By.id("state");
    private final By CITY_INPUT = By.id("city");
    private final By ZIPCODE_INPUT = By.id("zipcode");
    private final By TEL_NUMBER_INPUT = By.id("mobile_number");
    private final By CREATE_ACCOUNT_BUTTON = By.xpath("//button[@data-qa='create-account']");

    public SignUpPage() {
        super(getWebDriver());
    }


    //Account Create Info page

    public String getSignUpPageTitle(){
         return getPageTitle();
    }

    public String getAccountInfoText(){
        return getElementText(ACCOUNT_INFO_TITLE);
    }

    public void clickOnGender() {
        clickOnElement(CHECKBOX_MRS);
    }

    public boolean genderChecked(){
       return isElementSelected(CHECKBOX_MRS);
    }

    public void typePassword(String password){
        sendKeysOfData(PASSWORD_REG,password);
    }

    public void scrollAfterPassword(int count) {
        scroll(count);
    }
    public void daySelect(String text){
        selectElementByText(DAY_SELECT,text);
    }

    public void monthsSelect(String text){
        selectElementByText(MONTHS_SELECT,text);
    }

    public void yearsSelect(String text){
        selectElementByText(YEARS_SELECT,text);
    }
    public boolean newsletterChecked(){
        return isElementSelected(NEWSLETTER_CHECKBOX_INPUT);
    }

    public void setNewsletterCheckbox() {
        selectCheckbox(NEWSLETTER_CHECKBOX_INPUT);
    }
    public boolean offersChecked(){
        return isElementSelected(OFFERS_CHECKBOX_INPUT);
    }

    public void setOffersCheckbox() {
        selectCheckbox(OFFERS_CHECKBOX_INPUT);
    }

    public String getAddressInfoText(){
        return getElementText(ADDRESS_INFO_TITLE);
    }

    public void typeFirstName(String name){
        sendKeysOfData(NAME_INPUT,name);
    }

    public void typeLastName(String lastname){
        sendKeysOfData(LASTNAME_INPUT,lastname);
    }
    public void typeCompanyName(String company){
        sendKeysOfData(COMPANY_INPUT,company);
    }
    public void typeAddress1(String address1){
        sendKeysOfData(ADDRESS1_INPUT,address1);
    }
    public void setCountrySelect(String country) {
        selectElementByText(COUNTRY_SELECT,country);
    }
    public void typeState(String state){
        sendKeysOfData(STATE_INPUT,state);
    }

    public void typeCity(String city){
        sendKeysOfData(CITY_INPUT,city);
    }
    public void typeZip(String zip){
        sendKeysOfData(ZIPCODE_INPUT,zip);
    }
    public void typeTelNumber(String tel){
        sendKeysOfData(TEL_NUMBER_INPUT,tel);
    }

    public void clickOnCreateAccountButton() {
        clickOnElement(CREATE_ACCOUNT_BUTTON);
    }
    public boolean createAccountButtonDisplayed(){
        return isElementAvailable(CREATE_ACCOUNT_BUTTON);
    }





}
