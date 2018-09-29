package com.pageobjecttests.tests;

import com.pageobjecttests.objects.SignUpUser;
import com.pageobjecttests.pages.CreateAccountPage;
import com.pageobjecttests.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends TestTemplate {

    @Test
    public void signUp() {
        HomePage homePage = new HomePage(driver).open();
        homePage.goToRegistrationForm();
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.signUp(new SignUpUser());
        Assert.assertTrue(homePage.verifySignUp());
    }
}
