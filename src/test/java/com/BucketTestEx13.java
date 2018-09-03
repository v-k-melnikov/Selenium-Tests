package com;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class BucketTestEx13 extends TestBase {

    private WebDriverWait wait;
    private WebElement table;

    private void addProduct() {
        driver.findElement(By.cssSelector("[class^='product'] a")).click();
        try {
            new Select(driver.findElement(By.cssSelector("[name^='options']"))).selectByValue("Small");
        } catch (NoSuchElementException ignored) {
        }
        driver.findElement(By.cssSelector("[name='add_cart_product']")).click();
    }

    private void removeProduct() {
        try {
            driver.findElement(By.linkText("<< Back"));
        } catch (NoSuchElementException e) {
            table = driver.findElement(By.cssSelector("[class^='dataTable']"));
            driver.findElement(By.cssSelector("[name='remove_cart_item']")).click();
            wait.until(ExpectedConditions.stalenessOf(table));
        }
    }

    @Test
    public void test()   {
        wait = new WebDriverWait(driver, 3);
        driver.get("http://localhost/litecart/en/");
        addProduct();
        wait.until(ExpectedConditions.textMatches(By.cssSelector(".quantity"), Pattern.compile("1")));
        driver.navigate().back();
        addProduct();
        wait.until(ExpectedConditions.textMatches(By.cssSelector(".quantity"), Pattern.compile("2")));
        driver.navigate().back();
        addProduct();
        wait.until(ExpectedConditions.textMatches(By.cssSelector(".quantity"), Pattern.compile("3")));
        driver.findElement(By.linkText("Checkout »")).click();
        try {
            driver.findElement(By.className("shortcut")).click();
        } catch (NoSuchElementException ignored) {
        }
        removeProduct();
        removeProduct();
        removeProduct();

    }
}
