import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

    public static void main(String[] args) {
        //chrome driver
        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver(); //instantiating the driver
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement checkbox = driver.findElement(By.id("checkBoxOption1"));
        checkbox.click();
        System.out.println(checkbox.isSelected());
        checkbox.click();
        System.out.println(checkbox.isSelected());
        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
        driver.quit();
    }
}
