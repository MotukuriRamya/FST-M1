import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\gecko\\geckodriver.exe");


        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/");

        System.out.println(driver.getTitle()); //title

        WebElement element = driver.findElement(By.id("about-link"));
        System.out.println(element.getText());

        WebElement class_element = driver.findElement(By.className("green"));
        System.out.println(class_element.getText());

        WebElement link_element = driver.findElement((By.linkText("About Us")));
        System.out.println(link_element.getText());

        WebElement css_element = driver.findElement((By.cssSelector(".green")));
        System.out.println(css_element.getText());

        System.out.println(driver.getTitle());
        driver.close();
    }
}
