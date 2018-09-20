package com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LogTestEx17 extends TestBase {

    private String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);


    @Test
    public void test()   {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        login();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");

        // opening all folders

        try {
            while (true) {
                driver.findElement(By.xpath("//td[i[(@class='fa fa-folder')]]/a")).click();
            }
        } catch (NoSuchElementException ignored) {
        }

        // opening all products

        ArrayList<WebElement> list = new ArrayList<>(driver.findElements(By.xpath("//tbody/tr/td/a[not(@title='Edit')]")));
        String mainWindow = driver.getWindowHandle();
        for (WebElement el : list) {
            el.sendKeys(selectLinkOpeninNewTab);
            String newWindow = wait.until(thereIsWindowOtherThan(mainWindow));
            driver.switchTo().window(newWindow);
            driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
            Assert.assertEquals(0, driver.manage().logs().get("browser").getAll().size());
            driver.close();
            driver.switchTo().window(mainWindow);
        }
    }
}
