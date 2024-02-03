package com.entrata.util;

import org.openqa.selenium.WebDriver;

import com.entrata.pages.SignInPage;

public class PageObjectManager {
    private WebDriver driver;
    private SignInPage signInPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage getSignInPage() {
        signInPage = new SignInPage(driver);
        return signInPage;
    }
}
