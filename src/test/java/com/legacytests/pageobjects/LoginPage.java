package com.legacytests.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

  private static String URL_MATCH = "localhost/litecart/admin/";

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "login")
    private WebElement login;

    public LoginPage(WebDriver driver) {
        // checking page
        if (!driver.getCurrentUrl().contains(URL_MATCH)) {
            throw new IllegalStateException(
                    "This is not the page you are expected"
            );
        }
        PageFactory.initElements(driver, this);
    }

    public void loginAs(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        login.click();
    }
}