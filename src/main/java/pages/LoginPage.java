package pages;

import base.PageBase;
import utils.WaitUtils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.URI;

public class LoginPage extends PageBase {

    private final By loginForm = By.id("CustomerLoginForm");
    private final By emailField = By.cssSelector("input#CustomerEmail");
    private final By passwordField = By.cssSelector("input#CustomerPassword");
    private final By loginButton = By.cssSelector("#CustomerLoginForm button[type=submit]");
    private final By accountPageContentDiv = By.xpath("//h1[contains(text(), 'Felhasználói fiók')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void openLoginPage(String url) {
        // Open the login page and handle any consent popups
        driver.get(url);
        injectConsentCookie();
        System.out.println("Opening login page: " + url);
        // Refresh the page to ensure the consent cookie is applied
        driver.navigate().refresh();
    }

    private void injectConsentCookie() {
        // Inject a cookie to bypass the consent popup
        System.out.println("Adding consent cookie.");
        Cookie consentCookie = new Cookie.Builder("cookie_consent", "true")
                .domain(getDomainFromCurrentUrl())
                .path("/")
                .isHttpOnly(false)
                .isSecure(false)
                .build();
        driver.manage().addCookie(consentCookie);
    }

    private String getDomainFromCurrentUrl() {
        // Extract the domain from the current URL
        String currentUrl = driver.getCurrentUrl();
        return URI.create(currentUrl).getHost();
    }

    public void login(String email, String password) {
        // Ensure login form is visible
        System.out.println("Starting login process...");
        WaitUtils.waitForVisibility(driver, loginForm);

        System.out.println("Filling in login credentials.");
        WebElement emailInput = WaitUtils.waitForVisibility(driver, emailField);
        emailInput.sendKeys(email);
        WebElement passwordInput = WaitUtils.waitForVisibility(driver, passwordField);
        passwordInput.sendKeys(password);

        // Ensure the login form is displayed and the reset form is hidden
        ((JavascriptExecutor) driver).executeScript("document.querySelector('#CustomerLoginForm').style.display = 'block';");
        ((JavascriptExecutor) driver).executeScript("document.querySelector('#RecoverPasswordForm').style.display = 'none';");

        // Click the login button
        System.out.println("Clicking login button.");
        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
    }

    public boolean isLoginSuccessful() {
        // Wait for the account page content to be visible
        System.out.println("Checking if login was successful...");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountPageContentDiv)).isDisplayed();
    }
}
