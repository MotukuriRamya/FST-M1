package liveproject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GoogleKeep {

    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("com.google.android.keep");
        caps.setAppActivity(".activities.BrowseActivity");
        caps.noReset();

        //setting url
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));

    }

    @Test
    public void googleKeep() {

        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/edit_note_text")));

        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Adding description");
        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("Adding Title");

        driver.findElement(AppiumBy.accessibilityId("Open navigation drawer")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/open_search_bar_text_view")));

        Boolean res = driver.findElement(AppiumBy.id("com.google.android.keep:id/browse_note_interior_content")).isDisplayed();

        Assert.assertTrue(res);
    }
    }
