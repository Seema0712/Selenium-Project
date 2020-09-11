import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

    public static void main(String[] args) throws Exception{
        //chrome driver
        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver(); //instantiating the driver
        driver.get("https://jqueryui.com/droppable/");
        //frames some containers residing in the html page
        //we can switch b/w frames using index, id, webelement
        //we can get the no. of frames using findelements with iframe tag as well then use index
        //=== driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        driver.findElement(By.id("draggable")).click();
        //now for drag and drop using Actions class
        //this method requires 2 params source and target
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(By.id("draggable")),driver.findElement(By.cssSelector("#droppable"))).build().perform();
        Thread.sleep(3000);
        //for coming back to the html window back
        driver.switchTo().defaultContent();
        driver.quit();
    }
}
