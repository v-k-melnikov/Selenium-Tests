package com.ProductTestEx10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class ParalelTestBase {

    WebDriver driver;

    @Parameters("browser")

    @BeforeClass
    public void setUp(String browser) {


        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            // If browser is IE, then do this

        } else if (browser.equalsIgnoreCase("chrome")) {


            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
        } else if (browser.equalsIgnoreCase("edge")) {


        driver = new EdgeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}

