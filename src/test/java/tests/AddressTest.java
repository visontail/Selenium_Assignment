package tests;

import org.junit.Test;
import pages.LoginPage;
import pages.AddressPage;
import utils.ConfigReader;

import static org.junit.Assert.assertTrue;

public class AddressTest extends BaseTest {

    @Test
    public void userCanAddNewAddress() {
        String loginUrl = ConfigReader.get("login.url");
        String email = ConfigReader.get("username");
        String password = ConfigReader.get("password");
        String firstName = ConfigReader.get("address.firstName");
        String lastName = ConfigReader.get("address.lastName");
        String address1 = ConfigReader.get("address.address1");
        String city = ConfigReader.get("address.city");
        String postalCode = ConfigReader.get("address.postalCode");
        String phone = ConfigReader.get("address.phone");

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage(loginUrl);
        loginPage.login(email, password);
        assertTrue("Login failed", loginPage.isLoginSuccessful());

        // Add new address
        AddressPage addressPage = new AddressPage(driver);
        addressPage.openAddressSection();
        addressPage.addNewAddress(firstName, lastName, address1, city, postalCode, phone);

        // Assertion
        assertTrue("Address was not found", addressPage.isAddressDisplayed("Johnny Bravo"));

    }
}
