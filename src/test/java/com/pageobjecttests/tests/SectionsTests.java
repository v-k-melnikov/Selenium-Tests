package com.pageobjecttests.tests;

import com.pageobjecttests.pages.AdminPage;
import com.pageobjecttests.pages.CatalogPage;
import com.pageobjecttests.pages.CountriesPage;
import com.pageobjecttests.pages.GeoZonesPage;
import org.testng.annotations.Test;

public class SectionsTests extends TestTemplate {

    @Test
    public void catalogSectionTest() {
        AdminPage adminPage = new AdminPage(driver);
        CatalogPage catalogPage = adminPage.goToCatalogPage();
        catalogPage.verifyUrl();
        catalogPage.verifyHeader();
    }

    @Test
    public void countriesSectionTest() {
        AdminPage adminPage = new AdminPage(driver);
        CountriesPage countriesPage = adminPage.goToCountriesPage();
        countriesPage.verifyUrl();
        countriesPage.verifyHeader();
    }

    @Test
    public void geoZonesSectionTest() {
        AdminPage adminPage = new AdminPage(driver);
        GeoZonesPage geoZonesPage = adminPage.goToGeoZonesPage();
        geoZonesPage.verifyUrl();
        geoZonesPage.verifyHeader();
    }


}
