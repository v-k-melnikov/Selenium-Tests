package com.pageobjecttests.tests;

import com.pageobjecttests.pages.AdminLoginPage;
import com.pageobjecttests.pages.adminpages.AdminHomePage;
import com.pageobjecttests.pages.adminpages.CatalogPage;
import com.pageobjecttests.pages.adminpages.CountriesPage;
import com.pageobjecttests.pages.adminpages.GeoZonesPage;
import org.testng.annotations.Test;

public class SectionsTests extends TestTemplate {

    @Test
    public void catalogSectionTest() {
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver).open();
        adminLoginPage.login();
        AdminHomePage adminHomePage = new AdminHomePage(driver);
        CatalogPage catalogPage = adminHomePage.goToCatalogPage();
        catalogPage.verifyURL(CatalogPage.URL_PATH);
        catalogPage.verifyHeader();
    }

    @Test
    public void countriesSectionTest() {
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver).open();
        adminLoginPage.login();
        AdminHomePage adminHomePage = new AdminHomePage(driver);
        CountriesPage countriesPage = adminHomePage.goToCountriesPage();
        countriesPage.verifyURL(CountriesPage.URL_PATH);
        countriesPage.verifyHeader();
    }

    @Test
    public void geoZonesSectionTest() {
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver).open();
        adminLoginPage.login();
        AdminHomePage adminHomePage = new AdminHomePage(driver);
        GeoZonesPage geoZonesPage = adminHomePage.goToGeoZonesPage();
        geoZonesPage.verifyURL(GeoZonesPage.URL_PATH);
        geoZonesPage.verifyHeader();
    }


}
