import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Activity9 {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        Reporter.log(" URL launch |");
    }

    @BeforeMethod
    public void resetPage() {
        Reporter.log("Test Case Setup started |");
        driver.switchTo().defaultContent();
    }

    @Test
    public void simpleAlertTestCase() {
        Reporter.log("This is simple alert!");
        driver.findElement(By.id("simple")).click();
        String simpleAlertMsg = driver.switchTo().alert().getText();

        Assert.assertEquals(simpleAlertMsg,"This is a JavaScript Alert!");
        Reporter.log("Simple Alert Message :" + simpleAlertMsg);
        driver.switchTo().alert().accept();
        Reporter.log("Alert closed");

    }

    @Test
    public void confirmAlertTestCase() {
        Reporter.log("This is Confirmation alert");
        driver.findElement(By.id("confirm")).click();
        String confirm  = driver.switchTo().alert().getText();
        Assert.assertEquals(confirm,"This is a JavaScript Confirmation!");
        Reporter.log("Confirm alert: " + confirm);
        driver.switchTo().alert().accept();
        Reporter.log("Alert closed");



    }

    @Test
    public void promptAlertTestCase() {
        Reporter.log("This is prompt alert");
        driver.findElement(By.id("prompt")).click();
        String PromptText = driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("Ramya");
        Assert.assertEquals(PromptText,"This is a JavaScript Prompt!");
        driver.switchTo().alert().accept();
        Reporter.log("Alert closed");

    }

    @AfterClass
    public void close() {
        Reporter.log("Testing ended!!!");
        driver.close();
    }
}
