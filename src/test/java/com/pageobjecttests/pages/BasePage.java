package com.pageobjecttests.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    protected WebDriver driver;
    //    protected WebDriver driver = DriverProvider.getActiveDriver();
    private WebDriverWait waitFor;
    protected int timeOut = 5;
    public    String URL_PATH;

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
    public void verifyURL(String givenURL) {
        Assert.assertEquals(driver.getCurrentUrl(), givenURL);
    }



    public boolean isElementOnPage(String cssSelector) {
        changeImplicitWait(500, TimeUnit.MILLISECONDS);
        boolean isElementOnPage = true;
        try {
            // Get location on WebElement is rising exception when element is not present
            driver.findElement(By.cssSelector(cssSelector));
        } catch (NoSuchElementException ex) {
            isElementOnPage = false;
        } finally {
            restoreDefaultImplicitWait();
        }
        return isElementOnPage;
    }
    public boolean isElementHaveElement(WebElement el, String cssSelector) {
        changeImplicitWait(500, TimeUnit.MILLISECONDS);
        boolean isElementOnPage = true;
        try {
            // Get location on WebElement is rising exception when element is not present
            el.findElement(By.cssSelector(cssSelector));
        } catch (NoSuchElementException ex) {
            isElementOnPage = false;
        } finally {
            restoreDefaultImplicitWait();
        }
        return isElementOnPage;
    }
}
