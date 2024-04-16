package automationexersisice.setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import static automationexersisice.constants.Constants.CONFIG_FILE_PATH;

public class ConfigurationManager {

    public static final String URL;
    public static final String ENVIRONMENT;
    public static final String USERNAME;
    public static final String PASSWORD;

    static {
        Properties prop = new Properties();
        try(FileInputStream fs = new FileInputStream(CONFIG_FILE_PATH)) {
            prop.load(fs);
        } catch (FileNotFoundException e) {
            System.out.println("Configuration properties file cannot be found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        URL = prop.getProperty("url");
        USERNAME = prop.getProperty("username");
        PASSWORD = prop.getProperty("password");
        ENVIRONMENT = prop.getProperty("environment");
    }



}



