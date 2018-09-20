package com.PageObjectsEx19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class MainPage {

    private static String URL_MATCH = "litecart";

    private WebElement table;

    @FindBy(css = "[class^='product']")
    private WebElement firstProduct;



    MainPage(WebDriver driver) {
        // checking page
        if (!driver.getCurrentUrl().equals("http://localhost/litecart/en/")) {
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