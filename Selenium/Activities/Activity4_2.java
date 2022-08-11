import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\gecko\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/simple-form");
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//input[@id ='firstName']")).sendKeys("Ramya");
        driver.findElement(By.xpath("//input[@id ='lastName']")).sendKeys("Motukuri");
        driver.findElement(By.xpath("//input[@id ='email']")).sendKeys("abc1@gmail.com");
        driver.findElement(By.xpath("//input[@id ='number']")).sendKeys("2342344534");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

    }

 }
