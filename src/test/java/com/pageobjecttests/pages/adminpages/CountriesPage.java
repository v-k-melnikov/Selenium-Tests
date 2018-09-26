package com.pageobjecttests.pages.adminpages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class CountriesPage extends AdminBasePage {


    public final static String URL_PATH = "http://demo.litecart.net/admin/?app=countries&doc=countries";
    public final static String HEADER_NAME = "Countries";


    public CountriesPage(WebDriver driver) {
        super(driver);
    }

    public void verifyHeader() {
        Assert.assertEquals(header.getText(), HEADER_NAME);
    }

    public CountriesPage open() {
        driver.get(URL_PATH);
        return this;
    }
}
