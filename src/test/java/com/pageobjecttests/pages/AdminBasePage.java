package com.pageobjecttests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminBasePage extends BasePage {

    public final static String URL_PATH = "http://demo.litecart.net/admin/";

    @FindBy(xpath = "//span[text()='Appearance']")
    protected WebElement appearanceSection;
    @FindBy(xpath = "//span[text()='Catalog']")
    protected WebElement catalogSection;
    @FindBy(xpath = "//span[text()='Countries']")
    protected WebElement countriesSection;
    @FindBy(xpath = "//span[text()='Currencies']")
    protected WebElement currenciesSection;
    @FindBy(xpath = "//span[text()='Customers']")
    protected WebElement customersSection;
    @FindBy(xpath = "//span[text()='Geo Zones']")
    protected WebElement geozonesSection;
    @FindBy(xpath = "//span[text()='Modules']")
    protected WebElement modulesSection;
    @FindBy(xpath = "//span[text()='Orders']")
    protected WebElement ordersSection;
    @FindBy(xpath = "//span[text()='Pages']")
    protected WebElement pagesSection;
    @FindBy(xpath = "//span[text()='Reports']")
    protected WebElement reportsSection;
    @FindBy(xpath = "//span[text()='Settings']")
    protected WebElement settingsSection;
    @FindBy(xpath = "//span[text()='Slides']")
    protected WebElement slidesSection;
    @FindBy(xpath = "//span[text()='Tax']")
    protected WebElement taxSection;
    @FindBy(xpath = "//span[text()='Translations']")
    protected WebElement translationsSection;
    @FindBy(xpath = "//span[text()='Users']")
    protected WebElement usersSection;
    @FindBy(xpath = "//span[text()='vQmods']")
    protected WebElement vqmodsSection;

    public AdminBasePage(WebDriver driver) {
        super(driver);
    }

    public AdminBasePage open(){
        driver.get(URL_PATH);
        return this;
    }

}
