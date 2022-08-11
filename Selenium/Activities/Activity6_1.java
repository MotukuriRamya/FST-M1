import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_1 {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\gecko\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/dynamic-controls");
        System.out.println(driver.getTitle());
        WebElement checkbox = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input"));
        driver.findElement(By.id("toggleCheckbox")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        //clicking the button again
        driver.findElement(By.id("toggleCheckbox")).click();
       // WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(checkbox));
    }

}
