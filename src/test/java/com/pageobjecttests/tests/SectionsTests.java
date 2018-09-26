package com.pageobjecttests.tests;

import com.pageobjecttests.pages.adminpages.AdminHomePage;
import com.pageobjecttests.pages.adminpages.CatalogPage;
import com.pageobjecttests.pages.adminpages.CountriesPage;
import com.pageobjecttests.pages.adminpages.GeoZonesPage;
import org.testng.annotations.Test;

public class SectionsTests extends TestTemplate {

    @Test
    public void catalogSectionTest() {
        AdminHomePage adminHomePage = new AdminHomePage(driver).open();
        CatalogPage catalogPage = adminHomePage.goToCatalogPage();
        catalogPage.verifyUrl();
        catalogPage.verifyHeader();
    }

    @Test
    public void countriesSectionTest() {
        AdminHomePage adminHomePage = new AdminHomePage(driver).open();
        CountriesPage countriesPage = adminHomePage.goToCountriesPage();
        countriesPage.verifyUrl();
        countriesPage.verifyHeader();
    }

    @Test
    public void geoZonesSectionTest() {
        AdminHomePage adminHomePage = new AdminHomePage(driver).open();
        GeoZonesPage geoZonesPage = adminHomePage.goToGeoZonesPage();
        geoZonesPage.verifyUrl();
        geoZonesPage.verifyHeader();
    }


}
