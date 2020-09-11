import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;

public class ActionClasses {

    public static void main(String[] args) throws Exception{
        //chrome driver
        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver(); //instantiating the driver
        driver.get("https://www.amazon.in/");
        //Actions class for performing getures like hovering , double click , enter in caps and right click etc.
        Actions actions = new Actions(driver);
        //Actions class constructor needs driver instance and has several methods like first moveToElement then will build afterwards perform
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='nav-link-accountList']"))).build().perform();
        Thread.sleep(2000);
        //keyDown for using any specific key and double click on it for selection
        actions.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        Thread.sleep(2000);
        //contextClick is same as right click
        actions.contextClick().build().perform();
        Thread.sleep(1000);
        driver.quit();
    }
}
