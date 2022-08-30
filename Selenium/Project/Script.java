package CRMProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Script {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/index.php?action=Login&module=Users");
    }

    @Test(priority = 0)
    public void userLaunchesWebsite() {
        String Title = driver.getTitle();
        Assert.assertEquals(Title, "SuiteCRM");
        if (Title.equals("SuiteCRM"))
            driver.close();

    }

    @Test(priority = 1)
    public void userChecksHeaderURL() {
        String url = driver.findElement(By.xpath("//a[@title='SuiteCRM']")).getAttribute("href");
        System.out.println(url);
        driver.close();
    }

    @Test(priority = 2)
    public void userChecksCopyRights() {
        System.out.println(driver.findElement(By.xpath("//a[@id='admin_options']")).getText());
        driver.close();
    }


}