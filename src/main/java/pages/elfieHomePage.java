package pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import pageObjectModel.elfieHomePagePOM;
import models.messageList;

public class elfieHomePage extends elfieHomePagePOM {

    public elfieHomePage(AppiumDriver driver) {
        super(driver);
    } 
    
    public enum language{
    	English	
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
    	keywords.click(Txt_Language);
		keywords.click(Lbl_English);
    	return this;
    }
    
    //Verification    
    public void verifyLogo()
    {
    	Assert.assertEquals(keywords.isElementDisplayed(Ico_Logo), true); 
    	keywords.captureScreenshot("screenshots", generateFileName("Logo"));
    }
    
    public void verifyXButton()
    {
    	Assert.assertEquals(keywords.isElementDisplayed(Btn_X), true);  
    	keywords.captureScreenshot("screenshots", generateFileName("X_Button"));
    }
    public elfieHomePage verifyCopyrightSection()
    {
    	keywords.scrollToEndOfPage(Lbl_CopyRight, 25, 3);
    	Assert.assertEquals(keywords.isElementDisplayed(Lbl_CopyRight), true);
    	if(waitHelper.waitForVisibility(Txt_Language).getText() != language.English.toString())
    	{
    		switchLanguageToEnglish();
        	keywords.scrollToEndOfPage(Lbl_CopyRight, 30, 3);
    	}
    	WebElement element = waitHelper.waitForVisibility(Lbl_CopyRight);
    	LocalDateTime now = LocalDateTime.now();  
    	Assert.assertEquals(element.getText(), messageList.copyRight(now.getYear())); 
    	keywords.captureScreenshot("screenshots", generateFileName("Copyright"));
    	return this;
    } 
}
