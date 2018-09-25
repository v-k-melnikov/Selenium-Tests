package com.pageobjecttests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    protected WebDriver driver;
    //    protected WebDriver driver = DriverProvider.getActiveDriver();
    private WebDriverWait waitFor;
    protected int timeOut = 5;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitFor = new WebDriverWait(driver, timeOut);
        PageFactory.initElements(driver, this);
    }

    protected void changeImplicitWait(int value, TimeUnit timeUnit) {
        driver.manage().timeouts().implicitlyWait(value, timeUnit);
    }

    protected void restoreDefaultImplicitWait() {
        changeImplicitWait(timeOut, TimeUnit.SECONDS);
    }

    protected boolean isElementOnPage(WebElement element) {
        changeImplicitWait(500, TimeUnit.MILLISECONDS);
        boolean isElementOnPage = true;
        try {
            // Get location on WebElement is rising exception when element is not present
            element.getLocation();
        } catch (WebDriverException ex) {
            isElementOnPage = false;
        } finally {
            restoreDefaultImplicitWait();
        }
        return isElementOnPage;
    }
}
