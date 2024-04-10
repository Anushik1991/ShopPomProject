package automationexersice.data;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class DataInput {
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {
                       "Anushik", "anush@.ru","error" //data with domain wrong
                },
                {
                       "Anushik", "anushmail.ru","error" //data with domain wrong
                },
                {
                        "Anushik", "anush@mail","error" //data with domain wrong
                },
                {
                        "Anushik", "anush2001@gmail.com","Email Address already exist!"
                }
        };
    }




}