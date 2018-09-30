package com.pageobjecttests.pages;

import com.pageobjecttests.objects.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomePage extends BasePage {

    public final static String URL_PATH = "http://demo.litecart.net/";

    @FindBy(id = "campaign-products")
    private WebElement campaignProductsArea;
    @FindBy(id = "popular-products")
    private WebElement popularProductsArea;
    @FindBy(id = "latest-products")
    private WebElement latestProductsArea;
    @FindBy(linkText = "Campaign Products")
    private WebElement campaignProducts;
    @FindBy(linkText = "Popular Products")
    private WebElement popularProducts;
    @FindBy(linkText = "Latest Products")
    private WebElement latestProducts;
    @FindBy(css = "li[class='account dropdown']")
    private WebElement acountDropdown;
    @FindBy(css = "li[class='text-center']")
    private WebElement toRegistraionButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get(URL_PATH);
        return this;
    }

    public boolean isThereOnlyCampaignProductsAreaDisplayed() {
        return campaignProductsArea.isDisplayed() && !popularProductsArea.isDisplayed() && !latestProductsArea.isDisplayed();
    }

    private boolean isOnlyPopularProductsAreaDisplayed() {
        return popularProductsArea.isDisplayed() && !campaignProductsArea.isDisplayed() && !latestProductsArea.isDisplayed();
    }

    private boolean isOnlyLatestProductsAreaDisplayed() {
        return latestProductsArea.isDisplayed() && !popularProductsArea.isDisplayed() && !campaignProductsArea.isDisplayed();
    }

    private Set<Product> getAndVerifyProducts() {
        Set<Product> productSet = new HashSet<>();
        List<WebElement> productElements = driver.findElements(By.cssSelector("[class^='product column']"));
        for (WebElement el : productElements) {
            if (!el.isDisplayed()) continue;
            Product product = new Product();
            product.setName(el.findElement(By.cssSelector("a.link div.name")).getText());
            product.setLink(el.findElement(By.cssSelector("a.link")).getAttribute("href"));
            product.setHaveDiscount(isElementHaveElement(el, "strong.campaign-price"));
            if (!product.isHaveDiscount())
                product.setPrice(el.findElement(By.cssSelector("span.price")).getText());
            else {
                verifyStickerPresent(el);
                product.setPrice(el.findElement(By.cssSelector("s.regular-price")).getText());
                product.setDiscountPrice(el.findElement(By.cssSelector("strong.campaign-price")).getText());
            }
            product.setImagePath(el.findElement(By.cssSelector("[class='image img-responsive']")).getAttribute("src"));
            el.findElement(By.cssSelector("a")).click();
            ProductPopup productPopup = new ProductPopup(driver);
            productPopup.verifyProduct(product);
            productSet.add(product);
        }
        return productSet;
    }

    public void verifyAllProducts() {
        campaignProducts.click();
        Assert.assertTrue(isThereOnlyCampaignProductsAreaDisplayed());
        getAndVerifyProducts();
        popularProducts.click();
        Assert.assertTrue(isOnlyPopularProductsAreaDisplayed());
        getAndVerifyProducts();
        latestProducts.click();
        Assert.assertTrue(isOnlyLatestProductsAreaDisplayed());
        getAndVerifyProducts();
    }

    private void verifyStickerPresent(WebElement el) {
        el.findElement(By.cssSelector("[class='sticker sale']"));
    }

    public boolean verifySignUp() {
        return isElementOnPage("[class='alert alert-success']");
    }

    public void goToRegistrationForm() {
        acountDropdown.click();
        toRegistraionButton.click();
    }


}