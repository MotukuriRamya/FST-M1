import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8_1 {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\gecko\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/tables");

        List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[1]/td"));
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr"));

        System.out.println(cols.size());
        System.out.println(rows.size());


       List<WebElement> third_row = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[3]/td"));
        for(WebElement trow : third_row) {
           System.out.println(trow.getText());
        }
        System.out.println(driver.findElement(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]")).getText());


    }
}
