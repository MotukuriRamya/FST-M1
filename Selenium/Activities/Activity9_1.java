import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9_1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\gecko\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/selects");

        WebElement dropdown = driver.findElement(By.id("single-select"));
        Select select = new Select(dropdown);

        select.selectByVisibleText("Option 2");
        select.selectByIndex(2);
        select.selectByValue("4");

        List<WebElement> options = select.getOptions();

        for(WebElement option : options) {
            System.out.println(option.getText());
        }
    }

}
