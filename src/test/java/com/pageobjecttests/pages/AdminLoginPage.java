package com.pageobjecttests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage extends BasePage {

    public final static String URL_PATH = "http://demo.litecart.net/admin/login.php";

    @FindBy(css = "[name='username']")
    protected WebElement userNameField;
    @FindBy(css = "[name='password']")
    protected WebElement password;
    @FindBy(css = "button[name='login']")

    protected WebElement loginButton;

    public void login() {
        loginButton.click();
    }

    public AdminLoginPage(WebDriver driver) {
        super(driver);
    }

    public AdminLoginPage open() {
        driver.get(URL_PATH);
        return this;
    }

}
