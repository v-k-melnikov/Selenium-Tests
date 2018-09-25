package com.legacytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class WindowsTestEx14 extends TestBase {



    @Test
    public void test()   {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        login();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=countries&doc=edit_country']")).click();
        String mainWindow = driver.getWindowHandle();
        List<WebElement> list = driver.findElements(By.cssSelector("form a:not([id='address-format-hint'])"));
        for (WebElement el : list) {
            el.click();
//            Thread.sleep(1000);
            String newWindow = wait.until(thereIsWindowOtherThan(mainWindow));
            driver.switchTo().window(newWindow);
//            Thread.sleep(1000);
            driver.close();
            driver.switchTo().window(mainWindow);
        }
    }
}
