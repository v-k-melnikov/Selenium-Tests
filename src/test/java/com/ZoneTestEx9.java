package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZoneTestEx9 extends TestBase {

    private void testAlphabetOrder(ArrayList<String> arr) {
        ArrayList<String> sortedArr = arr;
        Collections.sort(sortedArr);
        Assert.assertEquals(arr, sortedArr);
    }

    @Test
    public void testCountriesWithZones() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");

        //checking alphabet order for countries

        List<WebElement> countryLinks = driver.findElements(By.cssSelector("table.dataTable tbody tr td:nth-of-type(5) a"));
        if (countryLinks.size() == 0) throw new NullPointerException();
        ArrayList<String> countryNames = new ArrayList<>();
        countryLinks.forEach(link -> countryNames.add(link.getText()));
        testAlphabetOrder(countryNames);

        //checking alphabet order for zones

        ArrayList<String> countryLinksToTest = new ArrayList<>();
        for (WebElement countryLink : countryLinks) {
            if (!countryLink.findElement(By.xpath("../../td[6]")).getText().equals("0"))
                countryLinksToTest.add(countryLink.getAttribute("href"));
        }
        for (String link : countryLinksToTest) {
            driver.get(link);
            List<WebElement> regionLinks = driver.findElements(By.cssSelector("table#table-zones tbody tr td:nth-of-type(3) input"));
            if (regionLinks.size() == 0) throw new NullPointerException();
            ArrayList<String> regionNames = new ArrayList<>();
            regionLinks.forEach(webElement -> regionNames.add(webElement.getAttribute("value")));
            testAlphabetOrder(regionNames);
        }
    }

    @Test
    public void testGeoZones() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        List<WebElement> countryElements = driver.findElements(By.cssSelector("form[name='geo_zones_form'] table tbody tr.row td:nth-of-type(3) a"));
        ArrayList<String> countryLinks = new ArrayList<>();
        countryElements.forEach(webElement -> countryLinks.add(webElement.getAttribute("href")));
        for (String link : countryLinks) {
            driver.get(link);

            List<WebElement> zones = driver.findElements(By.cssSelector("tr td select[name$='[zone_code]']"));
            for (WebElement a : zones)
                System.out.println(a.findElement(By.cssSelector("option[selected='selected']")).getText());
            if (zones.size() == 0) throw new NullPointerException();
            ArrayList<String> orderOfChosenZones = new ArrayList<>();
            zones.forEach(zone -> orderOfChosenZones.add(zone.findElement(By.cssSelector("option[selected='selected']")).getText()));
            System.out.println(orderOfChosenZones);
            testAlphabetOrder(orderOfChosenZones);
        }
    }
}
