package com.PageObjectsEx19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "login")
    private WebElement login;

    public LoginPage(WebDriver driver) {
        // checking page
        String URL_MATCH = "login";
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