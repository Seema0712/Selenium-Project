import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestion {

    public static void main(String[] args) throws Exception{
        //chrome driver
        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver(); //instantiating the driver
        driver.get("https://www.amazon.in/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wow");
        Thread.sleep(2000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.DOWN);
        //System.out.println(driver.findElement(By.id("twotabsearchtextbox")).getText()); //the text is not displaying here as it is hidden
        //so we will use JSexecutor here
        //Javascript DOM can extract hidden elements
        //because selenium cannot identify hidden elements - (Ajax implementation)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return document.getElementById('twotabsearchtextbox').value"; //return is used for returning the value from script
        String text = js.executeScript(script).toString();
        System.out.println(text);
        while (!(text.contains("oil"))) {
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.DOWN);
            text = js.executeScript(script).toString();
        }

        System.out.println(text);
        driver.quit();
    }
}
