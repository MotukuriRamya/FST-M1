import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity10 {

    WebDriver driver;
    Actions builder;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        builder = new Actions(driver);
        driver.get("https://www.training-support.net/selenium/sliders");
        Reporter.log(" URL launch |");
    }

    @Test (priority = 0)
    public void middleValue() {
        WebElement slider = driver.findElement(By.id("slider"));
        slider.click();
        //builder.clickAndHold(slider).moveByOffset(50, 0).release().build().perform();
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Slider moved to middle");
        Assert.assertEquals(volumeLevel,"50");

    }
    @Test (priority = 1)
    public void maximumValue() {
        WebElement slider = driver.findElement(By.id("slider"));
        builder.clickAndHold(slider).moveByOffset(75,0).release().build().perform();
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Slider moved to max");
        Assert.assertEquals(volumeLevel,"100");
    }

    @Test (priority = 2)
    public void minimumValue() {
        WebElement slider = driver.findElement(By.id("slider"));
        builder.clickAndHold(slider).moveByOffset(-75,0).release().build().perform();
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Slider moved to min");
        Assert.assertEquals(volumeLevel,"0");

    }
    @Test (priority = 3)
    public void valueThirtyPercentage() {
        WebElement slider = driver.findElement(By.id("slider"));
        builder.clickAndHold(slider).moveByOffset(-30,0).release().build().perform();
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Slider moved to 30%");
        Assert.assertEquals(volumeLevel,"30");

    }

    @Test (priority = 4)
    public void valueEightyPercentage() {
        WebElement slider = driver.findElement(By.id("slider"));
        builder.clickAndHold(slider).moveByOffset(45,0).release().build().perform();
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Slider moved to 80%");
        Assert.assertEquals(volumeLevel,"80");

    }
    @AfterClass
    public void close() {
        driver.close();
    }

}
