package com.entrata.pages;

import org.testng.annotations.Test;

import com.entrata.util.PageObjectManager;
import com.entrata.util.TestBase;

public class SignInPageTest extends TestBase {
    private PageObjectManager pageObjectManager;
    private SignInPage signinPage;

    @Test
    public void testSuccessfulLogin() {
        pageObjectManager = new PageObjectManager(driver);
        signinPage = pageObjectManager.getSignInPage();
        openBaseUrl(configLoader.getProperty("baseUrl"));
        signinPage.enterUsername(configLoader.getProperty("username"));
        signinPage.enterPassword(configLoader.getProperty("password"));
        signinPage.clickOnSignInButton();
    }
}