package com.heroku.tests;

import com.heroku.hooks.TestNgHook;
import org.testng.annotations.Test;
import com.heroku.pages.LandingPageObjects;

public class TestOne extends TestNgHook {

    @Test
    public void ChallengingDomTest(){
        LandingPageObjects lpPage = new LandingPageObjects(driver);
        lpPage.ClickOnExampleList("Entry Ad");
    }

}
