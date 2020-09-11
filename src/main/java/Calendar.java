import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Calendar {

    public static void main(String[] args) throws Exception{
        //chrome driver
        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver(); //instantiating the driver
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get("https://www.spicejet.com/");
        //click on calendar icon
        WebDriverWait wait = new WebDriverWait(driver,5000);
        String month = "August";
        String date = "15";
        String cal = "last";
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#ctl00_mainContent_view_date1")));
        driver.findElement(By.cssSelector("#ctl00_mainContent_view_date1")).click();
        //if we have select the particular month
        List<WebElement> months = driver.findElements(By.cssSelector(".ui-datepicker-month"));
        if(months.get(0).getText().contains(month))
            cal = "first";
        else
            {
                while (!(driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last'] //span[@class='ui-datepicker-month']")).getText().contains(month))) {
                    driver.findElement(By.xpath("//span[text()='Next']")).click();
                    Thread.sleep(1000);
                }
            }
        //select the particular date in calendar
        String xpath = "//div[@class='ui-datepicker-group ui-datepicker-group-"+cal+"']//td[@data-handler='selectDay']";
        List<WebElement> days = driver.findElements(By.xpath(xpath));
        for(WebElement day: days)
        {
            if(day.getText().contains(date)) {
                day.click();
                System.out.println("date selected");
                Thread.sleep(2000);
                break;
            }

        }
        driver.close();
        driver.quit();
    }
}
