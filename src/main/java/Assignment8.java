import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {

    public static void main(String[] args) throws Exception{
        //chrome driver
        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver(); //instantiating the driver
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("autocomplete")).sendKeys("United");
        Thread.sleep(2000);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return document.getElementById('autocomplete').value";
        String text = js.executeScript(script).toString();
        while (!(text.contains("Kingdom"))) {
            driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
            text = js.executeScript(script).toString();
        }
        System.out.println(text);
        driver.quit();
    }
}
