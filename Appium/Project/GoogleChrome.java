package liveproject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class GoogleChrome {
    AndroidDriver driver;
    WebDriverWait wait;
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
        driver = new AndroidDriver(serverURL, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        driver.get("https://www.training-support.net/selenium");

    }

    @Test
    public void googleChrome() throws InterruptedException {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.view.View")));

        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));

        driver.findElement(AppiumBy.accessibilityId("To-Do List  Elements get added at run time")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.EditText")));

        for (int i = 0; i <= 3; i++) {

            driver.findElement(AppiumBy.xpath("//android.widget.EditText[contains(@resource-id,'taskInput')]")).sendKeys("Tasks Adding " + i);
            driver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text,'Add Task')]")).click();
        }

        List<WebElement> lis = driver.findElements(AppiumBy.className("android.widget.TextView"));

        for(WebElement element :lis) {
          element.click();
        }
        List<WebElement> listOfZeros = driver.findElements(AppiumBy.id("tasksList"));

        if(listOfZeros.isEmpty()) {
            Assert.assertTrue(true);
        }

    }

    }
