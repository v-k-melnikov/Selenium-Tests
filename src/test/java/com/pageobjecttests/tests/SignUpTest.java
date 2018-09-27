package com.pageobjecttests.tests;

import com.pageobjecttests.objects.SignUpUser;
import com.pageobjecttests.pages.CreateAccountPage;
import com.pageobjecttests.pages.HomePage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SignUpTest extends TestTemplate {

    @Test
    public void signUp(){
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.signUp(new SignUpUser());
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.verifySignUp());
    }
}
