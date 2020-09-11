import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class MultipleWindows {

    public static void main(String[] args) {
        //chrome driver
        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver(); //instantiating the driver
        driver.get("https://accounts.google.com/signup");
        driver.findElement(By.xpath("//a[text()='Terms']")).click();
        //above command will open a new tab but selenium wise the handle with be in parent window only
        //title will be of first page only
        Set<String> handlers = driver.getWindowHandles(); //getWindowHandles will give the set of all handlers available
        Iterator<String> iterator = handlers.iterator();  //for iterating the set
        driver.switchTo().window(iterator.next());
        System.out.println(driver.getTitle());
        driver.switchTo().window(iterator.next());
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
