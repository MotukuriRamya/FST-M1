import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\gecko\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
        System.out.println(driver.getTitle());

        System.out.println(driver.findElement(By.xpath("//h3[@id='third-header']")).getText());
        System.out.println(driver.findElement(By.cssSelector(".ui.green.header")).getCssValue("Color"));
        System.out.println(driver.findElement(By.xpath("//button[contains(text(), 'Violet')]")).getAttribute("class"));
        System.out.println(driver.findElement(By.xpath("//div/div[2]/div[3]/button[2]")).getText());


    }
}
