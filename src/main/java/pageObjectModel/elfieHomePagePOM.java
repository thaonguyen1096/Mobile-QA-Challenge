package pageObjectModel;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import pages.basePage;

public class elfieHomePagePOM extends basePage {
    public elfieHomePagePOM(AppiumDriver driver) {
        super(driver);
    }
    
    protected By Ico_Logo = AppiumBy.xpath("//*[@content-desc='home']/android.widget.Image[@text='Elfie Logotype']");
    protected By Btn_HumburgerMenu = AppiumBy.androidUIAutomator("new UiSelector().text(\"menu\")");
    protected By Btn_X = AppiumBy.xpath("//android.view.View[@resource-id='w-nav-overlay-0']/preceding-sibling::android.view.View/android.widget.Button[@text='menu']");
    protected By Lbl_CopyRight = AppiumBy.xpath("//android.view.View[@content-desc='webflow']/preceding-sibling::android.widget.TextView");
    protected By Btn_AcceptAll = AppiumBy.androidUIAutomator("new UiSelector().text(\"Accept All\")");
    protected By Txt_Language = AppiumBy.xpath("//android.view.View[contains(@text, 'Language selected')]//android.widget.TextView");
    protected By Lbl_English = AppiumBy.xpath("//android.widget.ListView[@resource-id='weglot-listbox']/android.view.View[@resource-id='weglot-language-en']");
}
