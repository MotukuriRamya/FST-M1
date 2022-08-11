import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Activity10_1 {
    public  static void main(String[] args) {

    System.setProperty("webdriver.gecko.driver","C:\\gecko\\geckodriver.exe");

    WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/input-events");
        System.out.println(driver.getTitle());
        Actions builder = new Actions(driver);

       WebElement element = driver.findElement(By.cssSelector("#wrapD3Cube"));
       builder.click(element);

        WebElement cubeVal = driver.findElement(By.className("active"));
        System.out.println("Left Click: " + cubeVal.getText());

        //Double click
        builder.doubleClick(element).perform();
        cubeVal = driver.findElement(By.className("active"));
        System.out.println("Double Click: " + cubeVal.getText());

        //Right click
        builder.contextClick(element).perform();
        cubeVal = driver.findElement(By.className("active"));
        System.out.println("Right Click: " + cubeVal.getText());

        //Close browser
        //driver.close();


}
}
