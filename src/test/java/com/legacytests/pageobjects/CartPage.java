package com.legacytests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class CartPage {

    private final static String URL_MATCH = "http://localhost/litecart/en/checkout";

    private WebDriver driver;

    @FindBy(linkText = "<< Back")
    private WebElement backButton;

    @FindBy(css = "[name='remove_cart_item']")
    private WebElement removeItemButton;

    @FindBy(className = "shortcut")
    private WebElement shortcut;

    CartPage(WebDriver driver) {
        // checking page
        if (!driver.getCurrentUrl().equals(URL_MATCH)) {
            throw new IllegalStateException(
                    "This is not the page you are expected"
            );
        }
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    void removeProduct() {
        try {
            backButton.isEnabled();
        } catch (NoSuchElementException ignored) {
            WebElement table = driver.findElement(By.cssSelector("[class^='dataTable']"));
            removeItemButton.click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.stalenessOf(table));
        }
    }

    void stopCartForm() {
        shortcut.click();
    }

}