import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity1 {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new FirefoxDriver();
    }

    @Test
    public void userLaunachesWebSite(){
        driver.get("https://www.training-support.net/");
    }
    @AfterTest
    public void closing() {
        driver.close();
    }
}
