package com.pageobjecttests.pages.adminpages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AdminHomePage extends AdminBasePage {
    public final static String URL_PATH = "http://demo.litecart.net/admin/";
    public AdminHomePage(WebDriver driver) {
        super(driver);
    }
    public AdminHomePage open() {
        driver.get(URL_PATH);
        return this;
    }

}
