package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StaticPage extends PageBase {

    private final By textClubMember = By.xpath("//div[contains(@class, 'index-section')]//div[contains(@class, 'theme-block')]//h2[normalize-space(text())='Klubtagság']");
    private final By textShipping = By.xpath("//header[contains(@class, 'section-header')]//h1[contains(@class, 'section-header__title') and normalize-space(text())='Szállítási információk']");
    private final By textPayment = By.xpath("//header[contains(@class, 'section-header')]//h1[contains(@class, 'section-header__title') and normalize-space(text())='Fizetési információk']");

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

    public String getShippingText() {
        System.out.println("Waiting for shipping text to be visible.");
        WebElement shippingText = wait.until(ExpectedConditions.visibilityOfElementLocated(textShipping));
        return shippingText.getText();
    }

    public String getPaymentText() {
        System.out.println("Waiting for payment text to be visible.");
        WebElement paymentText = wait.until(ExpectedConditions.visibilityOfElementLocated(textPayment));
        return paymentText.getText();
    }
}
