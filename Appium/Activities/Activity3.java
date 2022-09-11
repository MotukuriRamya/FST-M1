package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {

    AndroidDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.sec.android.app.popupcalculator");
        options.setAppActivity(".Calculator");
        options.noReset();


        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }

    @Test
    public void additionTest() {
        // Perform the calculation
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(AppiumBy.accessibilityId("Plus")).click();
        driver.findElement(AppiumBy.accessibilityId("9")).click();
        driver.findElement(AppiumBy.accessibilityId("Equal")).click();

        // Find the result
        String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();

        // Assertion
        Assert.assertEquals(result, "14");
    }

    // Test method
    @Test
    public void subtractTest() {
        // Perform the calculation
        driver.findElement(AppiumBy.accessibilityId("1")).click();
        driver.findElement(AppiumBy.accessibilityId("0")).click();
        driver.findElement(AppiumBy.accessibilityId("Minus")).click();
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(AppiumBy.accessibilityId("Equal")).click();

        // Find the result
        String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();

        // Assertion
        Assert.assertEquals(result, "5");
    }

    // Test method
    @Test
    public void multiplyTest() {
        // Perform the calculation
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(AppiumBy.accessibilityId("Multiplication")).click();
        driver.findElement(AppiumBy.accessibilityId("1")).click();
        driver.findElement(AppiumBy.accessibilityId("0")).click();
        driver.findElement(AppiumBy.accessibilityId("0")).click();
        driver.findElement(AppiumBy.accessibilityId("Equal")).click();

        // Find the result
        String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();

        // Assertion
        Assert.assertEquals(result, "500");
    }

    // Test method
    @Test
    public void divideTest() {
        // Perform the calculation
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(AppiumBy.accessibilityId("0")).click();
        driver.findElement(AppiumBy.accessibilityId("Division")).click();
        driver.findElement(AppiumBy.accessibilityId("2")).click();
        driver.findElement(AppiumBy.accessibilityId("Equal")).click();

        // Find the result
        String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();

        // Assertion
        Assert.assertEquals(result, "25");
    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}

