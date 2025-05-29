package tests;

import org.junit.Test;
import pages.LoginPage;
import utils.ConfigReader;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void userCanLoginSuccessfully() {
        String loginUrl = ConfigReader.get("login.url");
        String email = ConfigReader.get("username");
        String password = ConfigReader.get("password");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage(loginUrl);
        loginPage.login(email, password);

        // assert login by checking if the account header is displayed
        assertTrue("Login should be successful", loginPage.isLoginSuccessful());
    }
}
