import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;
import java.util.Set;

public class Assignment4 {

    public static void main(String[] args) {
        //chrome driver
        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver(); //instantiating the driver
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String window1 = iterator.next();
        String window2 = iterator.next();
        driver.switchTo().window(window2);
        System.out.println(driver.getTitle());
        driver.switchTo().window(window1);
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
