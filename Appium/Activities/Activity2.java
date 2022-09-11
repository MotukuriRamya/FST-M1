package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {
    AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("com.android.chrome");
        caps.setAppActivity("com.google.android.apps.chrome.Main");
        caps.noReset();

        //setting url
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL,caps);

        driver.get("https://www.training-support.net/");

    }

    @Test
    public void getURL() {


        String header = driver.findElement(AppiumBy.className("android.widget.TextView")).getText();
        System.out.println(header);
        driver.findElement(AppiumBy.accessibilityId("About Us")).click();
        System.out.println(driver.findElement(AppiumBy.className("android.widget.TextView")).getText());
    }

}
