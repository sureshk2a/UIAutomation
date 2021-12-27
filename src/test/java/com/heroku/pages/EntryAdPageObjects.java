package com.heroku.pages;

import org.openqa.selenium.WebDriver;

public class EntryAdPageObjects {
    private WebDriver driver;

    public EntryAdPageObjects(WebDriver _driver) {
        this.driver = _driver;
    }

    String adPopup = "";

    public boolean isAdPopupDisplayed(){

        return true;
    }

    public String getTextDisplayedInAdPopup(){

        return "";
    }




}
