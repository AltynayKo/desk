package com.elearn.ta.driver;

import com.elearn.ta.util.ConfigReader;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSingleton {
    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getLocalDriver(String browser){
        if (driver.get()==null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver.set(new ChromeDriver());
                    break;
                case "edge":
                    driver.set(new EdgeDriver());
                    break;
                default:
                    driver.set(new FirefoxDriver());
            }
        }
        return driver.get();
    }
    public static WebDriver getRemoteDriver(String os, String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (driver.get() == null) {
            switch (os.toLowerCase()) {
                case "windows": {
                    capabilities.setPlatform(Platform.WIN11);
                    break;
                }
                case "mac": {
                    capabilities.setPlatform(Platform.MAC);
                    break;
                }
                case "linux": {
                    capabilities.setPlatform(Platform.LINUX);
                    break;
                }
            }
            switch (browser.toLowerCase()) {
                case "chrome": {
                    capabilities.setBrowserName("chrome");
                    break;
                }
                case "edge": {
                    capabilities.setBrowserName("MicrosoftEdge");
                    break;
                }
                case "firefox": {
                    capabilities.setBrowserName("firefox");
                    break;
                }
            }
        }
        driver.set(new RemoteWebDriver
                (new URL(ConfigReader.getRemoteDriverAddress()), capabilities));
        return driver.get();
    }
    public static void closeDriver(){
        driver.get().close();
        driver.remove();
    }
    public static WebDriver getDriver(){
        return driver.get();
    }
}
