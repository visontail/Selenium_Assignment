package pages;

import org.openqa.selenium.WebDriver;

import base.PageBase;

public class MainPage extends PageBase {

    private final String pageUrl = "https://vitmedical.hu/";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(pageUrl);
    }
}
