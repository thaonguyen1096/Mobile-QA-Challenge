package pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import pageObjectModel.elfieHomePagePOM;

public class elfieHomePage extends elfieHomePagePOM {

    public elfieHomePage(AppiumDriver driver) {
        super(driver);
    } 
    
    //Action
    public elfieHomePage clickMenuButton()
    {
    	keywords.click(Btn_HumburgerMenu);
    	return this;
    }    
    
    public elfieHomePage clickXButton()
    {
    	keywords.click(Btn_X);
    	return this;
    }   
    public elfieHomePage clickAcceptAllCookie()
    {
    	keywords.click(Btn_AcceptAll);
    	return this;
    }       
    public elfieHomePage switchLanguageToEnglish()
    {
    	
    	return this;
    }
    //Verification    
    public void verifyLogo()
    {
    	keywords.captureScreenshot("screenshots", generateFileName("Logo"));
    	Assert.assertEquals(keywords.isElementDisplayed(Ico_Logo), true); 
    }
    
    public void verifyXButton()
    {
    	keywords.captureScreenshot("screenshots", generateFileName("X_Button"));
    	Assert.assertEquals(keywords.isElementDisplayed(Btn_X), true);  
    }
    public elfieHomePage verifyCopyrightSection()
    {
    	keywords.scrollToEndOfPage(Lbl_CopyRight, 25, 3);
    	Assert.assertEquals(keywords.isElementDisplayed(Lbl_CopyRight), true);
    	if(waitHelper.waitForVisibility(Txt_Language).getText() != "English")
    	{
    		keywords.click(Txt_Language);
    		keywords.click(Lbl_English);
        	keywords.scrollToEndOfPage(Lbl_CopyRight, 30, 3);
    	}
    	WebElement element = waitHelper.waitForVisibility(Lbl_CopyRight);
    	LocalDateTime now = LocalDateTime.now();  
    	String currentYear = Integer.toString(now.getYear());
    	Assert.assertEquals(element.getText(), "Copyright © " + currentYear +" Elfie Pte. Ltd.");
    	keywords.captureScreenshot("screenshots", generateFileName("Copyright"));
    	return this;
    } 
}
