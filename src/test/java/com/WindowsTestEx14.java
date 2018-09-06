package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class WindowsTestEx14 extends TestBase {


    private static ExpectedCondition<String> thereIsWindowOtherThan(String window) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                TreeSet<String> windows = new TreeSet<>(driver.getWindowHandles());
                windows.remove(window);
                if (windows.size() > 0)
                    return windows.first();
                else
                    return null;
            }
        };
    }

    @Test
    public void test() throws InterruptedException {
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
