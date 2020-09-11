import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class Assignment6 {

    public static void main(String[] args) {
        //chrome driver
        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver(); //instantiating the driver
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        //select any checkbox e.g. second checkbox
        WebElement checkBox = driver.findElement(By.id("checkBoxOption2"));
        checkBox.click();
        String checkBoxText = checkBox.getAttribute("value");
        Select dropDown = new Select(driver.findElement(By.cssSelector("#dropdown-class-example")));
        dropDown.selectByValue(checkBoxText);
        driver.findElement(By.id("name")).sendKeys(checkBoxText);
        driver.findElement(By.cssSelector("#alertbtn")).click();
        if((driver.switchTo().alert().getText()).contains(checkBoxText))
            System.out.println(true);
        else
        System.out.println(false);
        driver.quit();
    }
}
