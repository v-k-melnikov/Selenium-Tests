package com.pageobjecttests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AdminPage extends BasePage {

    public final static String URL_PATH = "http://demo.litecart.net/admin/";

    @FindBy(css = "h1")
    protected WebElement header;
    @FindBy(xpath = "//span[text()='Catalog']")
    protected WebElement catalogSection;
    @FindBy(xpath = "//span[text()='Countries']")
    protected WebElement countriesSection;
    @FindBy(xpath = "//span[text()='Geo Zones']")
    protected WebElement geozonesSection;

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public AdminPage open() {
        driver.get(URL_PATH);
        return this;
    }

    public CatalogPage goToCatalogPage() {
        catalogSection.click();
        return new CatalogPage(driver);
    }

    public CountriesPage goToCountriesPage() {
        catalogSection.click();
        return new CountriesPage(driver);
    }

    public GeoZonesPage goToGeoZonesPage() {
        geozonesSection.click();
        return new GeoZonesPage(driver);
    }

    public void verifyUrl() {
        Assert.assertEquals(URL_PATH, driver.getCurrentUrl());
    }


}
