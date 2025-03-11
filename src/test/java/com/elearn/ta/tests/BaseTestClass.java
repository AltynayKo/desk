package com.elearn.ta.tests;

import com.elearn.ta.models.User;
import com.elearn.ta.utils.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

@Listeners(TestListener.class)
public class BaseTestClass {
    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public Properties properties;
    public Logger logger;
    public User currentUser;
    @BeforeClass
    @Parameters({"os", "browser"})
    public void setUp(String os, String br) throws IOException {

        //loading config.properties file
        FileReader file = new FileReader("./src//test//resources//config.properties");
        properties = new Properties();
        properties.load(file);

        logger = LogManager.getLogger(this.getClass());

        currentUser = new User(properties.getProperty("username"), properties.getProperty("password"));

        if (properties.getProperty("execution_env").equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            switch (os.toLowerCase()){
                case "windows": capabilities.setPlatform(Platform.WIN11); break;
                case "mac": capabilities.setPlatform(Platform.MAC); break;
                case "linux": capabilities.setPlatform(Platform.LINUX); break;
                default: System.out.println("Platform is not found"); return;
            }
            switch (br.toLowerCase()) {
                case "chrome": capabilities.setBrowserName("chrome"); break;
                case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
                case "firefox": capabilities.setBrowserName("Firefox"); break;
                default: System.out.println("Browser is not found"); return;
            }
            driver.set(new RemoteWebDriver(new URL("http://localhost:4444"), capabilities));
            logger.info("Running tests in REMOTE with setup: " + capabilities.getBrowserName() + ", " + capabilities.getPlatformName());
        }
        else if(properties.getProperty("execution_env").equalsIgnoreCase("local")) {
            switch (br.toLowerCase()) {
                case "chrome": driver.set(new ChromeDriver()); break;
                case "edge": driver.set(new EdgeDriver()); break;
                default: driver.set(new FirefoxDriver());
            }
            logger.info("Running tests LOCALLY with setup: " + br);
        } else {
            logger.error("Error while reading run environment/platform/browser");
        }
        driver.get().get(properties.getProperty("url"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.get().close();
        driver.remove();
        logger.info("Driver removed");
    }
}
