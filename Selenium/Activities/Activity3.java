import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","C:\\gecko\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/simple-form");
        System.out.println(driver.getTitle());
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement contact = driver.findElement(By.id("number"));

        firstName.sendKeys("Ramya");
        lastName.sendKeys("Motukuri");
        email.sendKeys("abc@gmail.com");
        contact.sendKeys("1234567884");
        WebElement submit = driver.findElement(By.xpath("//input[@value='submit']"));
        submit.click();

    }
}

