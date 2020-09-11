import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Assignment5 {

    public static void main(String[] args) {

        //chrome driver
        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver(); //instantiating the driver
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame(driver.findElement(By.name("frame-top")));
        List<WebElement> subFrames = driver.findElements(By.tagName("frame"));
        driver.switchTo().frame(subFrames.get(1));
        System.out.println(driver.findElement(By.id("content")).getText());
        driver.quit();
    }
}
