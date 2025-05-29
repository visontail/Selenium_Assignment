package pages;

import base.PageBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageBase {

    private final By closePopupButton = By.xpath("//span[@aria-label='dismiss cookie message']");
    private final By loginForm = By.id("CustomerLoginForm");
    private final By emailField = By.cssSelector("input#CustomerEmail");
    private final By passwordField = By.cssSelector("input#CustomerPassword");
    private final By loginButton = By.cssSelector("#CustomerLoginForm button[type=submit]");
    private final By accountPageContentDiv = By.xpath("//h1[contains(text(), 'Felhasználói fiók')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private void closePopupIfPresent() {
        try {
            WebElement closeCookieBtn = wait.until(ExpectedConditions.elementToBeClickable(closePopupButton));
            closeCookieBtn.click();
        } catch (Exception e) {
            System.out.println("[WARN] Unexpected error while closing cookie popup: " + e.getMessage());
        }
    }

    public void openLoginPage(String url) {
        driver.get(url);
        closePopupIfPresent();
    }

    public void login(String email, String password) {
        // Ensure login form is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginForm));

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailInput.sendKeys(email);
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordInput.sendKeys(password);

        // Ensure the login form is displayed and the reset form is hidden
        ((JavascriptExecutor) driver).executeScript("document.querySelector('#CustomerLoginForm').style.display = 'block';");
        ((JavascriptExecutor) driver).executeScript("document.querySelector('#RecoverPasswordForm').style.display = 'none';");

        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
    }

    public boolean isLoginSuccessful() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountPageContentDiv)).isDisplayed();
    }
}
