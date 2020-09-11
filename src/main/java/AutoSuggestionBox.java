import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestionBox {

    public static void main(String[] args) throws Exception{

        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.findElement(By.id("fromCity")).click();
        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("BOM");
        Thread.sleep(3000);
        String city = driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']")).getText();
        System.out.println(city);
        driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']")).click();

    }
}
