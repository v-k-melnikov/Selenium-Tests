package com.legacytests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class TestBase {

   public WebDriver driver;
    void login(){
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
        driver = null;
    }

     static ExpectedCondition<String> thereIsWindowOtherThan(String window) {
        return driver -> {
            TreeSet<String> windows = new TreeSet<>(driver.getWindowHandles());
            windows.remove(window);
            if (windows.size() > 0)
                return windows.first();
            else
                return null;
        };
    }
}