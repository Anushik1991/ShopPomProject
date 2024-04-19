package automationexersice.helper;

import com.google.common.reflect.TypeToken;
import com.google.gson.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    public static Object [][] readFromCSV(String path){
        String[] data = null;
        List<Object []> testCases = new ArrayList<>();
        String line = "";
        final String DELIMITER = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(path)))
        {
            while ((line = br.readLine()) != null) {
                data = line.split(DELIMITER);
                testCases.add(data);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return testCases.toArray(new Object[0][]);
    }


    public static Object [][] readFromJSON(String path) throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader(path));

        // Check if the JSON data is an array
        if (!jsonData.isJsonArray()) {
            throw new IllegalStateException("JSON data is not an array");
        }

        List<Object[]> testCases = new ArrayList<>();
        for (JsonElement element : jsonData.getAsJsonArray()) {
            JsonObject jsonObject = element.getAsJsonObject();
            String username = jsonObject.get("username").getAsString();
            String password = jsonObject.get("password").getAsString();
            testCases.add(new Object[]{username, password});
        }

        return testCases.toArray(new Object[0][]);
    }


}
