package com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddProductTestEx12 extends TestBase {

    @Test
    public void test() throws IOException, InterruptedException {
       login();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        driver.findElement(By.cssSelector("a.button:nth-of-type(2)")).click();
        driver.findElement(By.cssSelector("[name='status'][value='1']")).click();
        driver.findElement(By.cssSelector("[name^='name']")).sendKeys("Duck");
        driver.findElement(By.cssSelector("[name='code']")).sendKeys("12345");
        driver.findElement(By.cssSelector("[name^='product_groups'][value='1-3']")).click();
        driver.findElement(By.cssSelector("[name='quantity']")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.cssSelector("[name='quantity']")).sendKeys("123");
        File b = new File("src/test/resources/21-11568-20101120151108_1.jpg");
        String absolute = b.getCanonicalPath();
        driver.findElement(By.cssSelector("[name^='new_images']")).sendKeys(absolute);
        driver.findElement(By.cssSelector("[name='date_valid_from']")).sendKeys("05-11-2018");
        driver.findElement(By.cssSelector("[name='date_valid_to']")).sendKeys("05-11-2018");
        Thread.sleep(2000);  //just for take a look
        driver.findElement(By.cssSelector("[href='#tab-information']")).click();
        new Select(driver.findElement(By.cssSelector("[name='manufacturer_id']"))).selectByValue("1");
        driver.findElement(By.cssSelector("[name='keywords']")).sendKeys("123");
        driver.findElement(By.cssSelector("[name^='short_description']")).sendKeys("123");
        driver.findElement(By.cssSelector(".trumbowyg-editor")).sendKeys("123");
        driver.findElement(By.cssSelector("[name^='head_title']")).sendKeys("123");
        driver.findElement(By.cssSelector("[name^='meta_description']")).sendKeys("123");
        Thread.sleep(2000);  //just for take a look
        driver.findElement(By.cssSelector("[href='#tab-prices']")).click();
        driver.findElement(By.cssSelector("[name='purchase_price']")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.cssSelector("[name='purchase_price']")).sendKeys("123");
        new Select(driver.findElement(By.cssSelector("[name='purchase_price_currency_code']"))).selectByValue("USD");
        driver.findElement(By.cssSelector("[name='gross_prices[USD]']")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.cssSelector("[name='gross_prices[USD]']")).sendKeys("123");
        driver.findElement(By.cssSelector("[name='gross_prices[EUR]']")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.cssSelector("[name='gross_prices[EUR]']")).sendKeys("123");
        Thread.sleep(2000);  //just for take a look
        driver.findElement(By.cssSelector("[name='save']")).click();
        List<String> listOfProducts = new ArrayList<>();
        driver.findElements(By.cssSelector(".row a")).forEach(el -> listOfProducts.add(el.getText()));
        Thread.sleep(2000);  //just for take a look
        Assert.assertTrue(listOfProducts.contains("Duck"));
    }
}

