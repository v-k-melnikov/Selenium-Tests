package com;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class AddProductTestEx12 extends TestBase {

    public void SetDatepicker(WebDriver driver, String cssSelector, String date) {
        ExpectedCondition<Boolean> expectation = driver1 -> {
            assert driver1 != null;
            return driver1.findElement(By.cssSelector(cssSelector)).isDisplayed();
        };
        new WebDriverWait(driver, 30).until(expectation);
        ((JavascriptExecutor) driver).executeScript(
                String.format("$('{0}').datepicker('setDate', '{1}')", cssSelector, date));
    }

    @Test
    public void test() throws IOException {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        driver.findElement(By.cssSelector("a.button:nth-of-type(2)")).click();
        WebElement content = driver.findElement(By.id("tab-general"));
        content.findElement(By.cssSelector("[name='status'][value='1']")).click();
        content.findElement(By.cssSelector("[name^='name']")).sendKeys("Duck");
        content.findElement(By.cssSelector("[name='code']")).sendKeys("12345");
        content.findElement(By.cssSelector("[name^='categories'][value='0']")).click();
        content.findElement(By.cssSelector("[name^='categories'][value='1']")).click();
        content.findElement(By.cssSelector("[name^='product_groups'][value='1-3']")).click();
        content.findElement(By.cssSelector("[name='quantity']")).sendKeys(Keys.CONTROL + "a");
        content.findElement(By.cssSelector("[name='quantity']")).sendKeys("123");
        File b = new File("src/test/resources/21-11568-20101120151108_1.jpg");
        String absolute = b.getCanonicalPath(); // may throw IOException
        System.out.println(absolute);
        content.findElement(By.cssSelector("[name^='new_images']")).sendKeys(absolute);
       /* driver.switchTo().frame(content.findElement(By.cssSelector("[name='date_valid_from']")));
        SetDatepicker(driver, "[name='date_valid_from']", "02/20/2002");
        Thread.sleep(5000);*/
//        http://barancev.github.io/how-to-set-datepicker-value//

    }
}

