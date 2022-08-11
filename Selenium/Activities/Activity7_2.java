import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7_2 {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\gecko\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//input[contains(@class, '-username')]")).sendKeys("Ramya");
        driver.findElement(By.xpath("//input[contains(@class, '-password')]")).sendKeys("password");
        driver.findElement(By.xpath("//input[contains(@class, '-password')]")).sendKeys("password");
        driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following::input"));
        driver.findElement(By.xpath("//label[contains(text(), 'mail')]/following-sibling::input"));

        driver.findElement(By.xpath("//button[@onclick ='signUp()']")).click();

        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + loginMessage);


    }

    }
