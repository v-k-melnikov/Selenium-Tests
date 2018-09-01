package com;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class BucketTestEx13 extends TestBase {

    private void addProduct() {
        driver.findElement(By.cssSelector("[class^='product'] a")).click();
        try {
            new Select(driver.findElement(By.cssSelector("[name^='options']"))).selectByValue("Small");
        } catch (NoSuchElementException ignored) {}
        driver.findElement(By.cssSelector("[name='add_cart_product']")).click();
    }

    @Test
    public void test()   {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        driver.get("http://localhost/litecart/en/");
        addProduct();
        wait.until(ExpectedConditions.textMatches(By.cssSelector(".quantity"), Pattern.compile("1")));
        driver.navigate().back();
        addProduct();
        wait.until(ExpectedConditions.textMatches(By.cssSelector(".quantity"), Pattern.compile("2")));
        driver.navigate().back();
        addProduct();
        wait.until(ExpectedConditions.textMatches(By.cssSelector(".quantity"), Pattern.compile("3")));
    }
}
