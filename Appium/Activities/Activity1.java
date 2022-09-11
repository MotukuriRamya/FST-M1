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

 public class Activity1 {

    AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("com.sec.android.app.popupcalculator");
        caps.setAppActivity(".Calculator");
        caps.noReset();

        //setting url
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL,caps);
    }

    @Test
    public void multiplyTest() {
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_06")).click();
        driver.findElement(AppiumBy.accessibilityId("Multiplication")).click();
        driver.findElement(AppiumBy.accessibilityId("5")).click();

        driver.findElement(AppiumBy.accessibilityId("Equal")).click();

        String res = driver.findElement(AppiumBy.accessibilityId("30 Calculation result")).getText();
        System.out.println(res);

        Assert.assertEquals(res,"30");

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
