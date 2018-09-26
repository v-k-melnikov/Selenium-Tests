package com.pageobjecttests.tests;

import com.pageobjecttests.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends TestTemplate{

    @Test
    public void productsVerification(){
        HomePage homePage = new HomePage(driver).open();
        Assert.assertTrue(homePage.isOnlyCampaignProductsAreaDisplayed());
        homePage.verifyAllProducts();
    }

}
