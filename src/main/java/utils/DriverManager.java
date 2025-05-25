package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
                URI uri = new URI("http://selenium:4444/wd/hub");
                driver = new RemoteWebDriver(uri.toURL(), options);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to create WebDriver: " + e.getMessage());
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
