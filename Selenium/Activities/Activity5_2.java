import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_2 {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\gecko\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/dynamic-controls");
        System.out.println(driver.getTitle());
        if(driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected())
            driver.findElement(By.id("toggleCheckbox")).click();
        System.out.println(driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected());

    }

    }
