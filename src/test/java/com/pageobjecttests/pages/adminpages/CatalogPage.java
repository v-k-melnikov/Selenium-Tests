package com.pageobjecttests.pages.adminpages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CatalogPage extends AdminBasePage {


    public final static String URL_PATH = "http://demo.litecart.net/admin/?app=catalog&doc=catalog";
    public final static String HEADER_NAME = "Catalog";


    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public void verifyHeader() {
        Assert.assertEquals(header.getText(), HEADER_NAME);
    }

    public CatalogPage open() {
        driver.get(URL_PATH);
        return this;
    }
}
