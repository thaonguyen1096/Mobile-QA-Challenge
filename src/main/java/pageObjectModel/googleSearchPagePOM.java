package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import pages.basePage;

public class googleSearchPagePOM extends basePage {    
    public googleSearchPagePOM(AppiumDriver driver) {
        super(driver);
	}
	protected By Txt_Search = AppiumBy.xpath("//android.view.View/android.widget.EditText");
    protected By Ico_Search = AppiumBy.xpath("//android.view.View[@resource-id='main']/android.view.View/android.widget.Button");
    protected By Btn_Search = AppiumBy.xpath("//*[@content-desc='Search']");
    protected By Lbl_FirstResult = AppiumBy.xpath("//android.view.View[@resource-id='rso']/android.view.View//android.widget.TextView[contains(@text, 'https:')]");
}
