package helpers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class waitHelper {

    private WebDriverWait wait;
    private int defaultTimeout = 30;

    // Constructor to initialize driver and wait
    public waitHelper(AppiumDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));  // Adjust timeout as needed
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public WebElement waitForVisibility(By locator, int timeout) {
		this.wait.withTimeout(Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickability(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean waitForElementToDisappear(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
