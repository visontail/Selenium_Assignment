package pages;

import base.PageBase;
import utils.TestDataGenerator;
import utils.WaitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AddressPage extends PageBase {

    private final By addressLink = By.xpath("//a[contains(@href, '/account/addresses')]");
    private final By addNewAddressBtn = By.cssSelector("button.address-new-toggle");
    private final By addressForm = By.id("AddressNewForm");

    private final By firstNameField = By.xpath("//input[@id='AddressFirstNameNew']");
    private final By lastNameField = By.xpath("//input[@id='AddressLastNameNew']");
    private final By addressField = By.xpath("//input[@id='AddressAddress1New']");
    private final By cityField = By.xpath("//input[@id='AddressCityNew']");
    private final By countryDropdown = By.xpath("//select[@id='AddressCountryNew']");
    private final By countrySelectOption = By.xpath("//option[@value='Hungary']");
    private final By zipField = By.xpath("//input[@id='AddressZipNew']");
    private final By phoneField = By.xpath("//input[@id='AddressPhoneNew']");

    private final By saveButton = By.id("addresses-add-submit");
    private final By addressContainer = By.xpath("//p[contains(text(), 'Johnny Bravo')]");

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public void openAddressSection() {
        System.out.println("Opening address section.");
        WaitUtils.waitForClickable(driver, addressLink);
        driver.findElement(addressLink).click();
    }

    public void addNewAddress(String firstName, String lastName, String address, String postalCode, String phone) {
        System.out.println("Starting 'add new address' process..");
        System.out.println("Click to add new address.");
        WaitUtils.waitForClickable(driver, addNewAddressBtn);
        driver.findElement(addNewAddressBtn).click();

        System.out.println("Waiting for address form to be visible.");
        WaitUtils.waitForVisibility(driver, addressForm);

        // Generate a random city name
        String cityName = TestDataGenerator.generateRandomCityName();
        System.out.println("Generated random city: " + cityName);

        System.out.println("Filling in address form.");
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(cityField).sendKeys(cityName);
        driver.findElement(countryDropdown).click();
        driver.findElement(countrySelectOption).click();
        driver.findElement(zipField).sendKeys(postalCode);
        driver.findElement(phoneField).sendKeys(phone);

        System.out.println("Clicking save button.");
        WaitUtils.waitForClickable(driver, saveButton);
        driver.findElement(saveButton).click();
    }

    public boolean isAddressDisplayed(String name) {
        System.out.println("Checking if address is displayed.");
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(addressContainer, name));
    }
}
