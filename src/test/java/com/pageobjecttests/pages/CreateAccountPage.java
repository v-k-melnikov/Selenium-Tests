package com.pageobjecttests.pages;

import com.pageobjecttests.objects.SignUpUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CreateAccountPage extends BasePage {

    public final static String URL_PATH = "http://demo.litecart.net/create_account";

    @FindBy(xpath = "//*[@name='firstname']")
    private WebElement firstNameField;
    @FindBy(xpath = "//*[@name='lastname']")
    private WebElement lastNameField;
    @FindBy(xpath = "//*[@name='address1']")
    private WebElement addressField;
    @FindBy(xpath = "//*[@name='postcode']")
    private WebElement postCodeField;
    @FindBy(xpath = "//*[@name='city']")
    private WebElement cityField;
    @FindBy(xpath = "//[@name='email']")
    private WebElement emailField;
    @FindBy(xpath = "//*[@name='phone']")
    private WebElement phoneField;
    @FindBy(xpath = "//*[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@name='confirmed_password']")
    private WebElement confirmPasswordField;
    @FindBy(xpath = "//*[@name='country_code']")
    private WebElement countryCodeField;
    @FindBy(xpath = "//*[@name='zone_code']")
    private WebElement zoneCodeField;
    @FindBy(xpath = "//*[@type='submit']")
    private WebElement submitButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void signUp(SignUpUser user) {
        firstNameField.sendKeys(user.getFirstName());
        lastNameField.sendKeys(user.getLastName());
        addressField.sendKeys(user.getAddress());
        postCodeField.sendKeys(user.getPostcode());
        cityField.sendKeys(user.getCity());
        emailField.sendKeys(user.getEmail());
        phoneField.sendKeys(user.getPhone());
        passwordField.sendKeys(user.getPassword());
        confirmPasswordField.sendKeys(user.getPassword());

        Select countrySelector = new Select(countryCodeField);
        countrySelector.selectByVisibleText(user.getCountry());

        Select zoneSelector = new Select(zoneCodeField);
        zoneSelector.selectByVisibleText(user.getZone());

        submitButton.click();
    }

    public CreateAccountPage open() {
        driver.get(URL_PATH);
        return this;
    }
}
