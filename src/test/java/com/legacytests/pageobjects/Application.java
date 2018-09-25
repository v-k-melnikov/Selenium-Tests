package com.legacytests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class Application {
    private WebDriver driver;
    private WebDriverWait wait;
    private CartPage cartPage;
    private LoginPage loginPage;
    private MainPage mainPage;
    private ProductPage productPage;

    @FindBy(linkText = "Checkout »")
    private WebElement cart;

    private void moveToCart() {
        PageFactory.initElements(driver, this);
        cart.click();
    }

    Application(WebDriver driver) {
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
        this.driver.get("http://localhost/litecart/en/");
    }

    void addProductToCart() {
        mainPage = new MainPage(driver);
        mainPage.clickOnProduct();
        productPage = new ProductPage(driver);
        int numberofProductsPlusOne = Integer.parseInt(productPage.quantity.getText()) + 1;
        productPage.addProduct();
        wait.until(ExpectedConditions.textMatches(By.cssSelector(".quantity"), Pattern.compile(numberofProductsPlusOne + "")));
        driver.navigate().back();
    }

    void prepareCart() {
        moveToCart();
        cartPage = new CartPage(driver);
        try {
            cartPage.stopCartForm();
        } catch (NoSuchElementException ignored) {
        }
    }

    void removeProduct() {
        cartPage.removeProduct();
    }
}
