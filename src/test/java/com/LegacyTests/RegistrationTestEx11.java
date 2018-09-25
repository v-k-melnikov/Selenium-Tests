package com.legacytests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RegistrationTestEx11 extends TestBase {

    private String randomMail() {
        DateFormat df = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date today = Calendar.getInstance().getTime();
        String todayDate = df.format(today);
        return "randomemail" + todayDate + "@gmail.com";
    }

    @Test
    public void test() {

        driver.get("http://localhost/litecart/en/create_account");
        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("Vasya");
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("Pupkin");
        driver.findElement(By.cssSelector("[name='address1']")).sendKeys("1st West street, 12");
        driver.findElement(By.cssSelector("[name='postcode']")).sendKeys("40000");
        driver.findElement(By.cssSelector("[name='city']")).sendKeys("New York");
        new Select(driver.findElement(By.cssSelector("[name='country_code']"))).selectByValue("US");
        String newmail = randomMail();
        driver.findElement(By.cssSelector("[name='email']")).sendKeys(newmail);
        driver.findElement(By.cssSelector("[name='phone']")).sendKeys("+11111111111");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("qwerty123");
        driver.findElement(By.cssSelector("[name='confirmed_password']")).sendKeys("qwerty123");
        driver.findElement(By.cssSelector("[name='create_account']")).click();
        driver.findElement(By.cssSelector("#box-account li:nth-of-type(4) a")).click();
        driver.findElement(By.cssSelector("[name='email'")).sendKeys(newmail);
        driver.findElement(By.cssSelector("[name='password'")).sendKeys("qwerty123");
        driver.findElement(By.cssSelector("[name='login']")).click();
        driver.findElement(By.cssSelector("#box-account li:nth-of-type(4) a")).click();

    }

}
