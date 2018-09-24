package com.LegacyTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SectionsTestEx7 extends TestBase {

    @Test
    public void test()   {
       login();
        int numOfSections = driver.findElements(By.cssSelector("li[id='app-']")).size();
        if (numOfSections == 0) throw new NullPointerException();
        for (int i = 1; i <= numOfSections; i++) {          
            driver.findElement(By.cssSelector("li[id='app-']:nth-of-type(" + i + ")")).click();
            int numOfItems = driver.findElements(By.cssSelector("li[id^='doc'")).size();
            for (int j = 1; j <= numOfItems; j++) {
                driver.findElement(By.cssSelector(".docs li:nth-of-type(" + j + ")")).click();
                driver.findElement(By.tagName("h1"));
            }
        }
    }
}
