package com.entrata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//div[@class='header-desktop-buttons hide-on-mobile']//a[text()='Sign In']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[contains(@href, 'sso.entrata.com/entrata/login')]")
    private WebElement propertyManagerLogin;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        this.username.sendKeys(username);
    }

    public void enterPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }
}
