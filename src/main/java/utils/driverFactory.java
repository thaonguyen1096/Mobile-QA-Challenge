package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class driverFactory {
    private static AppiumDriver driver;

    // Private constructor to prevent instantiation
    private driverFactory() { }

    public static AppiumDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    private static AppiumDriver createDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_7_API_34");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("enableMultiWindows", true);
        caps.setCapability(MobileCapabilityType.LANGUAGE, "en");
        caps.setCapability(MobileCapabilityType.LOCALE, "US");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        return new AndroidDriver(url, caps);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
