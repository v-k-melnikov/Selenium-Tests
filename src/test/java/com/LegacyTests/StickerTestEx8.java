package com.LegacyTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class StickerTestEx8 extends TestBase {
    private int numOfStickers;

    @Test
    public void test()  {
        driver.get("http://localhost/litecart");
        List<WebElement> products = driver.findElements(By.cssSelector("[class^='product']"));
        if (products.size() == 0) throw new NullPointerException();
        for (WebElement product : products) {
            numOfStickers = product.findElements(By.cssSelector("[class^='sticker']")).size();
            Assert.assertEquals(1, numOfStickers);
        }
    }
}
