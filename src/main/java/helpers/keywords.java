package helpers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.commons.io.FileUtils;
import pages.basePage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class keywords {

    protected AppiumDriver driver;
    protected waitHelper waitHelper;

    public keywords(AppiumDriver driver) {
        this.driver = driver;
        this.waitHelper = new waitHelper(driver);
    }

    // Perform click action with wait
    public void click(By locator) {
    	waitHelper.waitForClickability(locator).click();
    }

    // Enter text into an input field with wait
    public void sendKeyOnTextBox(By locator, String text) {
        WebElement element = waitHelper.waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    // Check if an element is displayed
    public boolean isElementDisplayed(By locator) {
        try {
            return waitHelper.waitForVisibility(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isElementDisplayed(By locator, int timeout) {
        try {
            return waitHelper.waitForVisibility(locator, timeout).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void swipe(String direction, double percentage, int times,
            int expectedLeft, int expectedTop, int expectedHeight, int expectedWidth, int velocity) {

		Map<String, Object> scrollObject = new HashMap<>();
		String command = "mobile: scrollGesture";
		Dimension size = driver.manage().window().getSize();
		
		// Calculate defaults
		int left = expectedLeft;
		int top = (expectedTop == 0) ? 300 : expectedTop;
		int height = (expectedHeight == 0) ? size.getHeight() - 500 : expectedHeight;
		int width = (expectedWidth == 0) ? size.getWidth() / 2 : expectedWidth;
		
		// Swipe without specific element
        scrollObject.put("left", left);
        scrollObject.put("top", top);
        scrollObject.put("width", width);
        scrollObject.put("height", height);
        scrollObject.put("percent", percentage);
        scrollObject.put("direction", direction);
		driver.executeScript(command, scrollObject);		
    }

	public void scrollToEndOfPage(By locator, int maxTime, double percentage){
		Dimension size = driver.manage().window().getSize();
		for(int i = 0; i < maxTime; i++)
		{
			if(isElementDisplayed(locator, 2)) {
				return;
			}
			swipe("down", percentage, 1, 2, 200, size.getHeight() - 300, 0, 0);
		}
		Assert.fail("Element not found " + locator );
	}
    
    // Capture a screenshot (for validation steps)
    public void captureScreenshot(String folderPath, String fileName) {
        File screenshot = ((AppiumDriver)driver).getScreenshotAs(OutputType.FILE);
        
        // Create the destination folder if it doesn't exist
        File destFolder = new File(folderPath);
        if (!destFolder.exists()) {
            destFolder.mkdirs();  // Create the directory including any missing parent directories
        }        
        File destFile = new File(folderPath + "/" + fileName);
        try {
            FileUtils.copyFile(screenshot, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
