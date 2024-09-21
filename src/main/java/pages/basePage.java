package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Set;
import helpers.keywords;
import helpers.waitHelper;

public class basePage {

    protected AppiumDriver driver;
    protected keywords keywords;
    protected waitHelper waitHelper;

    public basePage(AppiumDriver driver) {
        this.driver = driver;
        this.keywords = new keywords(driver);  
        this.waitHelper = new waitHelper(driver);  
    }
    

    //Switch to WebView context
    public void switchToWebContext() {
        // Get all available contexts (NATIVE_APP and WEBVIEW)
        Set<String> contextNames = ((AndroidDriver)driver).getContextHandles();
        System.out.println("Available contexts: " + contextNames);

        // Loop through the contexts and switch to WebView context
        for (String contextName : contextNames) {
            if (contextName.contains("WEBVIEW")) {
            	((AndroidDriver)driver).context(contextName);  // Switch to web view
                System.out.println("Switched to Web context: " + contextName);
                break;  // Exit once we switch to the web context
            }
        }
    }

    // Switch to Native context
    public void switchToNativeContext() {
    	((AndroidDriver)driver).context("NATIVE_APP");  
        System.out.println("Switched to Native context");
    }
    
    public String datetimeToString(LocalDateTime datetime, String format)
    {
    	return DateTimeFormatter.ofPattern(format, Locale.ENGLISH).format(datetime).toString();
    }
    
    public String generateFileName(String fileName)
    {
    	return String.format("%s_%s.png", fileName, datetimeToString(LocalDateTime.now(), "yyyymmdd_HHmmss"));
    }
}
