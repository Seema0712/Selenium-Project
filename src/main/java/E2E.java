import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class E2E {

    public static void main(String[] args) throws Exception{
        //chrome driver
        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver(); //instantiating the driver
        driver.get("https://www.spicejet.com/"); // go to the url
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //wait for sometime
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click(); //selecting from city
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@value='MAA']")).click(); //from city value
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='AMD']")).click(); //To city value
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click(); //friends&family checkbox
        driver.findElement(By.id("divpaxinfo")).click(); //for passengers dropdown
        Thread.sleep(2000);
        Select passenger = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult"))); //adult dropdown under passengers
        passenger.selectByVisibleText("2");
        driver.findElement(By.xpath("//*[@class='ui-datepicker-trigger']")).click(); //selecting from date calendar
        driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-active")).click(); //selecting today's date
        boolean val = false;
        String style = driver.findElement(By.id("Div1")).getAttribute("style"); //checking for one-way return date disabled
        if(style.contains("1"))
            val = true;
        System.out.println(val);
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click(); //click on search button in flights
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}
