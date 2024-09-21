package baseTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.AppiumDriver;
import utils.driverFactory;
import java.net.MalformedURLException;

public class baseTest {
    protected AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        driver = driverFactory.getDriver();
    }

    @AfterTest
    public void tearDown() {
        driverFactory.quitDriver();
    }
}
