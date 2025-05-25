package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

public abstract class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver();
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
