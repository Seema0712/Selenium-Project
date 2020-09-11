import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RealTimeExercise {

    public static void main(String[] args) throws Exception{
        //chrome driver
        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver(); //instantiating the driver
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //1.get all the count of all the links in the page
        System.out.println(driver.findElements(By.tagName("a")).size());
        //2.now to get links in footer section only then we have to limit the driver scope
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());
        //3.now in footer also suppose we need to check column wise how many links they are holding so for that again limit scope of driver
        WebElement footerColumn1 = driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul"));
        List<WebElement> columnLinks = footerColumn1.findElements(By.tagName("a"));
        System.out.println(columnLinks.size());
        //4. now click on the links and check if they are working
        //we can utilise ctrl key to open link in new tab
        String newTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
        for(int i=1; i<columnLinks.size();i++)
        {
            columnLinks.get(i).sendKeys(newTab);
            //driver.navigate().back(); //this is not good practice since it will take so much time
        }
        //now we can traverse thru the tabs to get the titles
        Set<String> tabs = driver.getWindowHandles();
        Iterator<String> iterator = tabs.iterator();
        while (iterator.hasNext())
        {
            driver.switchTo().window(iterator.next());
            System.out.println(driver.getTitle());
        }
        driver.quit();
    }
}
