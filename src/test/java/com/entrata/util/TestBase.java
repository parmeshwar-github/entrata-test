package com.entrata.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

    protected WebDriver driver;
    public ConfigLoader configLoader;

    @BeforeMethod
    public void setUp() {
        configLoader = new ConfigLoader();
        String browserType = configLoader.getProperty("browserType");

        switch (browserType.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browserType + "\" is not supported.");
        }
        driver.manage().window().maximize();
    }

    protected void openBaseUrl(String url) {
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
