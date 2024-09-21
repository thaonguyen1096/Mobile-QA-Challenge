package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import baseTest.baseTest;
import pages.googleSearchPage;
import pages.elfieHomePage;

public class elfieTest extends baseTest {
    googleSearchPage googlePage;
    elfieHomePage elfieHomePage;

    @Test
    public void testGoogleSearchAndVerify()
    {        
        driver.get("https://www.google.com/");        
        googlePage.switchToNativeContext();
        googlePage.searchFor("Elfie")
        	.openFirstResult();
        elfieHomePage.verifyLogo();
        elfieHomePage.clickMenuButton()
        .verifyXButton();
        elfieHomePage.clickXButton()
        .clickAcceptAllCookie()
        .verifyCopyrightSection();
    }
    
    @BeforeTest
    public void initTest(){
    	googlePage = new googleSearchPage(driver);
        elfieHomePage = new elfieHomePage(driver);
    }
}
