import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_2 {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\gecko\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.training-support.net/selenium/ajax");
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//button[@class='ui violet button']")).click();
        WebElement element = driver.findElement(By.xpath("//h1[contains(text(),'HELLO!')]"));
        wait.until(ExpectedConditions.visibilityOf(element));
        System.out.println(element.getText());
        WebElement element1 =  driver.findElement(By.id("ajax-content"));
        wait.until(ExpectedConditions.visibilityOf(element1));

        System.out.println(element1.getText());

        driver.close();

    }
}
