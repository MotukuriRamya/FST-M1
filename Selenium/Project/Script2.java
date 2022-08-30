package CRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Script2 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/index.php?action=Login&module=Users");
    }

    public void userLogsIn() {
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id='bigbutton']")).click();
    }
    @Test(priority = 0)
    public void userEntersValues() {
        userLogsIn();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String login_value = driver.findElement(By.xpath("//span[contains(text(),'My Open Cases')]")).getText();
        Assert.assertEquals(login_value,"MY OPEN CASES");
        if(login_value.equals("MY OPEN CASES")){
            driver.close();
        }
    }
    @Test  (priority = 1)
    public void userGetsColors(){
        userLogsIn();
        String color_val = driver.findElement(By.xpath("//div[@id='toolbar']")).getCssValue("color");
        System.out.println(color_val);
        driver.close();
    }
    @Test  (priority = 2)
    public void userChecksActivity() {
        userLogsIn();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Boolean Activity_menu = driver.findElement(By.cssSelector("#grouptab_3")).isDisplayed();
        System.out.println(Activity_menu);
        Assert.assertTrue(Activity_menu);
        driver.close();
    }

    @Test (priority = 3)
    public void userReadsInformation() {
        userLogsIn();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#grouptab_0")).click();
        driver.findElement(By.cssSelector("#moduleTab_9_Leads")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[10]")));
        driver.findElement(By.xpath("//tbody/tr[1]/td[10]")).click();
        String number = driver.findElement(By.xpath("//div[@id='ui-id-5']")).getText();
        System.out.println(number.substring(65,87));
        //System.out.println(number);
        driver.close();
    }
    @Test  (priority = 4)
    public void userTraversing() {
        userLogsIn();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#grouptab_0")).click();
        driver.findElement(By.cssSelector("#moduleTab_9_Accounts")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Email Address')]")));
        List<WebElement> names = driver.findElements(By.xpath("//tbody/tr/td[7]"));
        for (int i = 0; i < 10; i = i+2){
            System.out.println(names.get(i).getText());
        }
        driver.close();
    }
    @Test  (priority = 5)
    public void userChecksNames() {
        userLogsIn();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#grouptab_0")).click();
        driver.findElement(By.cssSelector("#moduleTab_9_Leads")).click();
        wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Email')]")));
        List<WebElement> Lead_User_Names = driver.findElements(By.xpath("//tbody/tr/td[8]"));
        List<WebElement> Lead_Names = driver.findElements(By.xpath("//tbody/tr/td[3]"));
        for(int j =0 ; j<=2;j++){
            Lead_Names.remove(j);
        }
        for(int i = 0; i < Lead_User_Names.size();i++){
            System.out.println("Name:" + Lead_Names.get(i).getText() + "UserName: " + Lead_User_Names.get(i).getText());
        }
        driver.close();
    }
}
