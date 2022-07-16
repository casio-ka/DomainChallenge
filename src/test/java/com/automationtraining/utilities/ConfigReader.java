package com.automationtraining.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    // declaring Properties object at class level, so it can be accessible in static method
    private  static Properties properties = new Properties();

    // using the static block to load the file only once
    static {
        try {
            FileInputStream in = new FileInputStream("config.properties");
            properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read(String key){
        return properties.getProperty(key) ;
    }
}
