package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FrameworkProperties {
    private String result = "";
    private InputStream inputStream;

    public String getProperty(String key) {
        try {
            Properties properties = new Properties();

            properties.load(new FileInputStream(System.getProperty("user.dir") +"/src" +"/test" +"/resources" +"/properties"+"/execution.properties"));
            this.result = properties.getProperty(key);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
