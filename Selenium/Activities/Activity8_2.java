import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8_2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\gecko\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/tables");

        System.out.println("rows: "+driver.findElements(By.xpath("//table[contains(@class, 'sortable')]/tbody/tr")).size());
        System.out.println("cols: " + driver.findElements(By.xpath("//table[contains(@class, 'sortable')]/tbody/tr[1]/td")).size());

        System.out.println(driver.findElement(By.xpath("//table[contains(@class, 'sortable')]/tbody/tr[2]/td[2]")).getText());
        driver.findElement(By.xpath("//th[contains(text(),'Name')]")).click();
        System.out.println(driver.findElement(By.xpath("//table[contains(@class, 'sortable')]/tbody/tr[2]/td[2]")).getText());

        List<WebElement> footers = driver.findElements(By.xpath("//table[contains(@class,'sortable')]/tfoot/tr"));
        for(WebElement footer:footers) {
            System.out.println(footer.getText());
        }
    }

}
