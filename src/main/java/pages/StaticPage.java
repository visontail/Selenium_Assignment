package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StaticPage extends PageBase {

    private final By textClubMember = By.xpath("//h2[contains(text(), 'Klub')]");

    public StaticPage(WebDriver driver) {
        super(driver);
    }

    public void open(String url) {
        System.out.println("Opening static page: " + url);
        driver.get(url);
    }

    public String getClubMemberText() {
        System.out.println("Waiting for club member text to be visible.");
        WebElement clubMemberText = wait.until(ExpectedConditions.visibilityOfElementLocated(textClubMember));
        return clubMemberText.getText();
    }
}
