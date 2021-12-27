package com.heroku.hooks;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utils.Base;

public class TestNgHook {

    public WebDriver driver;
    Base base;

    @BeforeSuite
    public void LaunchBrowser(){
        base = new Base();
        driver = base.getDriverInstance();
    }

    @BeforeMethod
    public void LaunchUrl(){
        driver.get("http://the-internet.herokuapp.com/");
    }

    @AfterSuite
    public void QuitBrowser(){
        driver.quit();
    }

}
