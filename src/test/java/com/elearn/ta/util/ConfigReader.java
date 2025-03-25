package com.elearn.ta.util;

import model.User;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();;
    private static final String EXECUTION_ENVIRONMENT = "execution.env";
    private static final String REMOTE_DRIVER_ADDRESS = "remote.driver.address";
    private static final String BASE_URL = "dev.env.url";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public ConfigReader(){

    }
    public static void loadProperties() throws IOException {
        FileReader file = new FileReader("src/test/resources/config.properties");
        properties.load(file);
    }
    public static String getExecutionEnvironment(){
        return properties.getProperty(EXECUTION_ENVIRONMENT);
    }
    public static String getRemoteDriverAddress(){
        return properties.getProperty(REMOTE_DRIVER_ADDRESS);
    }
    public static String getBaseUrl(){
        return properties.getProperty(BASE_URL);
    }
    public static User getUserData(){
        return new User (properties.getProperty(USERNAME),
                properties.getProperty(PASSWORD));
    }
}
