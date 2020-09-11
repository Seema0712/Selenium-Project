import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class Dropdown {

    public static void main(String[] args) throws Exception{
        //chrome driver
        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver(); //instantiating the driver
        driver.get("https://www.spicejet.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Select s = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"))); //Select class can be used for static drop down whose tag is select
        s.selectByValue("AED");
        Thread.sleep(3000);
        //s.selectByIndex(1); //this also can be used based on the indices
        //s.selectByVisibleText("INR"); //whatever text is displaying
        // for dropdown which is not haveing select tag
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@value='MAA']")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpat'h("(//a[@value='GOI'])[2]")).click(); //using indexes as multiple instances were there
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='AMD']")).click();
        //handling checkboxes =====
        WebElement var = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));
        System.out.println(var.isSelected());
        var.click();
        System.out.println(var.isSelected());
        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        Select passenger = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
        passenger.selectByVisibleText("2");
        driver.findElement(By.xpath("//*[@class='ui-datepicker-trigger']")).click();
        driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-active")).click();
        //System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled()); //its not working here as the disabled is also working
        //we shud go for that attribute which is changing
        boolean val = false;
        String style = driver.findElement(By.id("Div1")).getAttribute("style");
        System.out.println(style);
        if(style.contains("1"))
            val = true;
        System.out.println(val);
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        style = driver.findElement(By.id("Div1")).getAttribute("style");
        System.out.println(style);
        if(style.contains("1"))
            val = true;
        System.out.println(val);
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }
}
