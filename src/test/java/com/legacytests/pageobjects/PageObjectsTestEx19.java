package com.legacytests.pageobjects;

import com.legacytests.TestBase;
import org.testng.annotations.Test;

public class PageObjectsTestEx19 extends TestBase {

    @Test
    public void test() {
        Application app = new Application(driver);
        app.addProductToCart();
        app.addProductToCart();
        app.addProductToCart();
        app.prepareCart();
        app.removeProduct();
        app.removeProduct();
        app.removeProduct();
    }
}
