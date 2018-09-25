package com.legacytests.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class MainPage {

    private final static String URL_MATCH = "http://localhost/litecart/en/";


    @FindBy(css = "[class^='product']")
    private WebElement firstProduct;


    MainPage(WebDriver driver) {
        // checking page
        if (!driver.getCurrentUrl().equals(URL_MATCH)) {
            throw new IllegalStateException(
                    "This is not the page you are expected"
            );
        }
        PageFactory.initElements(driver, this);
    }

    void clickOnProduct() {
        firstProduct.click();
    }

}