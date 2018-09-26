package com.pageobjecttests.pages;

import com.pageobjecttests.objects.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductPopup extends BasePage {

    @FindBy(css = "#box-product .title")
    private WebElement productName;
    @FindBy(css = "#box-product span.regular-price")
    private WebElement price;
    @FindBy(css = "#box-product s.regular-price")
    private WebElement regularPrice;
    @FindBy(css = "#box-product strong.campaign-price")
    private WebElement discountPrice;
    @FindBy(css = "#box-product .img-responsive")
    private WebElement imagePath;

    public ProductPopup(WebDriver driver) {
        super(driver);
    }

    private boolean haveDiscount() {
        return isElementOnPage(discountPrice);
    }

    public void verifyProduct(Product product) {
        Assert.assertEquals(product.getName(), productName.getText());
        Assert.assertEquals(product.isHaveDiscount(), haveDiscount());
        if (!haveDiscount())
            Assert.assertEquals(product.getPrice(), price.getText());
        else {
            Assert.assertEquals(product.getDiscountPrice(), discountPrice.getText());
            Assert.assertEquals(product.getPrice(), regularPrice.getText());
        }
        Assert.assertEquals(product.getImagePath(), imagePath.getAttribute("src"));
        }
    }
