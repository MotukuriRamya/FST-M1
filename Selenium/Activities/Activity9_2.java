import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9_2 {
    public static void main(String[] args) {
    System.setProperty("webdriver.gecko.driver","C:\\gecko\\geckodriver.exe");

    WebDriver driver = new FirefoxDriver();
    driver.get("https://training-support.net/selenium/selects");


    WebElement dropdown = driver.findElement(By.id("multi-select"));
    Select select = new Select(dropdown);

    if(select.isMultiple()) {
        select.selectByVisibleText("Javascript");
        select.selectByValue("node");
        //to select 4,5,6 by index
        for (int i = 4; i <= 6; i++) {
            select.selectByIndex(i);
        }
        select.deselectByValue("node");
        select.deselectByIndex(7);

        List<WebElement> elements = select.getAllSelectedOptions();
        // print 1st selected element
        System.out.println(elements.get(1).getText());
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
    }
    select.deselectAll();
    }
}
