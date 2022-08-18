import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.time.Duration;

public class Activity2 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
    }

    @Test(priority = 0)
    public void userLaunachesWebSite(){
        driver.get("https://www.training-support.net/selenium/target-practice");
    }
    @AfterClass
    public void closing() {
        driver.close();
    }
    @Test(priority = 1)
    public void getTitle() {
        String Title = driver.getTitle();
        System.out.println(Title);
        Assert.assertEquals(Title,"Target Practice");
    }

    @Test(priority = 2)
    public void userFinds() {
       // driver.get("https://www.training-support.net/selenium/target-practice");
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Black')]")));
        String Button_Color = driver.findElement(By.xpath("//button[contains(text(),'Black')]")).getText();
        Assert.assertEquals(Button_Color,"black","Wrong color");
    }
    @Test(enabled = false)
    public void enableMethod(){
        System.out.println("This method is skipped");
    }

    @Test
    public void enableMethodSkip()   {
        throw new SkipException("This method is skipped using ecpection");
    }
}
