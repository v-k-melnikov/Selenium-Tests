package com.pageobjecttests.pages.adminpages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GeoZonesPage extends AdminBasePage {

    public final static String URL_PATH = "http://demo.litecart.net/admin/?app=geo_zones&doc=geo_zones";
    public final static String HEADER_NAME = "Geo Zones";


    public GeoZonesPage(WebDriver driver) {
        super(driver);
    }

    public void verifyHeader() {
        Assert.assertEquals(header.getText(), HEADER_NAME);
    }

    public GeoZonesPage open() {
        driver.get(URL_PATH);
        return this;
    }
}
