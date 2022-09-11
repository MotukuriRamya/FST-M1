package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity4 {

    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.samsung.android.app.contacts");
        options.setAppActivity("com.samsung.android.contacts.contactslist.PeopleActivity");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));

    }

    @Test
    public void ContactsTest() {

        driver.findElement(AppiumBy.accessibilityId("More options")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("com.samsung.android.app.contacts:id/simNameEdit")));

        driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/simNameEdit")).sendKeys("Testing Appium");

        driver.findElement(AppiumBy.id("00000000-0000-02f3-ffff-ffff00000205")).sendKeys("9876543211");

        driver.findElement(AppiumBy.accessibilityId("Save")).click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Phone 9 5 4 1, Double tap to call.,SIM1")));

        String contactNum = driver.findElement(AppiumBy.accessibilityId("Phone 9 5 4 1, Double tap to call.,SIM1")).getText();
        Assert.assertEquals(contactNum, "Aaditya Varma");



    }
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
    }
