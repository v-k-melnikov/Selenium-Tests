package com.pageobjecttests.pages.adminpages;

import com.pageobjecttests.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AdminBasePage extends BasePage {


    @FindBy(css = "h1")
    protected WebElement header;
    @FindBy(xpath = "//span[text()='Catalog']")
    protected WebElement catalogSection;
    @FindBy(xpath = "//span[text()='Countries']")
    protected WebElement countriesSection;
    @FindBy(xpath = "//span[text()='Geo Zones']")
    protected WebElement geozonesSection;

    public AdminBasePage(WebDriver driver) {
        super(driver);
    }



    public CatalogPage goToCatalogPage() {
        catalogSection.click();
        return new CatalogPage(driver);
    }

    public CountriesPage goToCountriesPage() {
        countriesSection.click();
        return new CountriesPage(driver);
    }

    public GeoZonesPage goToGeoZonesPage() {
        geozonesSection.click();
        return new GeoZonesPage(driver);
    }




}
