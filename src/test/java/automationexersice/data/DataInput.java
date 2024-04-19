package automationexersice.data;
import automationexersice.helper.DataReader;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;

import static automationexersice.helper.DataReader.readFromCSV;
import static automationexersice.helper.DataReader.readFromJSON;


public class DataInput {
    @DataProvider(name = "signUpData")
    public Object[][] signUpData() {
        return new Object[][]{
                {
                       "Anushik", "anush@.ru" //data with domain wrong
                },
                {
                       "Anushik", "anushmail.ru" //data with domain wrong
                },
                {
                        "Anushik", "anush@mail" //data with domain wrong
                },
                {
                        "Anushik", "anush2001@gmail.com","Email Address already exist!"
                }
        };
    }

    @DataProvider(name = "loginDataCSV")
    public Object[][] loginDataCSV(){

        return readFromCSV("C:\\Users\\User\\IdeaProjects\\ShopPomProject\\src\\test\\resources\\email.csv");

    }
    @DataProvider(name = "loginDataJSON")
    public Object[][] loginDataJSON() throws FileNotFoundException {
        return DataReader.readFromJSON("C:\\Users\\User\\IdeaProjects\\ShopPomProject\\src\\test\\resources\\userData.json");

    }

}