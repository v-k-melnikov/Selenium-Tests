package com.legacytests.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

class ProductPage {

    private final static String URL_MATCH = "http://localhost/litecart/en/";

    @FindBy(css = "[name^='options']")
    private WebElement options;

    private Select selectOptions;

    @FindBy(css = "[name='add_cart_product']")
    private WebElement addProductButton;

    @FindBy(css = ".quantity")
    WebElement quantity;

    ProductPage(WebDriver driver) {
        // checking page
        if (!driver.getCurrentUrl().startsWith(URL_MATCH)) {
            throw new IllegalStateException(
                    "This is not the page you are expected"
            );
        }
        PageFactory.initElements(driver, this);
        try {
            selectOptions = new Select(options);
        } catch (NoSuchElementException ignored) {
        }
    }

    void addProduct() {
        try {
            selectOptions.selectByValue("Small");
        } catch (NullPointerException ignored) {
        }
        addProductButton.click();
    }
}
