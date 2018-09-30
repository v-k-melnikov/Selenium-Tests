package com.pageobjecttests.core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CommonExpectedConditions {


    private CommonExpectedConditions() {
    }

    public static ExpectedCondition<Boolean> pageLoaded() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor exec = (JavascriptExecutor) driver;
                return exec.executeScript("return document.readyState").equals("complete");
            }

            @Override
            public String toString() {
                return "Page didn't load";
            }
        };
    }

    public static ExpectedCondition<Boolean> newWindowPresent() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                Object[] windows = driver.getWindowHandles().toArray();
                return (windows.length > 1);
            }

            @Override
            public String toString() {
                return "New window not found";
            }
        };
    }
}
