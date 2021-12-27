package com.heroku.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DynamicXpath;
import utils.seleniumUtils.SeleniumActions;


public class LandingPageObjects extends SeleniumActions {

    private WebDriver driver;

    public LandingPageObjects(WebDriver _driver){
        super(_driver);
        this.driver = _driver;
    }

    String exampleList = "//div[@id='content']//li/a[text()='%s']";

    public void ClickOnExampleList(String exampleName){
        String locator = DynamicXpath.constructXpath(exampleList,exampleName);
        waitAndClickElement(By.xpath(locator));
    }

}
