import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
    }

    @Test(priority = 0)
    public void userLaunchesWebSite(){
        driver.get("https://www.training-support.net/selenium/login-form");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        String Text = driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText();
        Assert.assertEquals(Text,"Welcome Back, admin");
    }

    @AfterClass
    public void closing() {
        driver.close();
    }
}
