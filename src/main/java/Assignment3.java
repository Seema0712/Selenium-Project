import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Assignment3 {

    public static void main(String[] args) {
        //chrome driver
        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver(); //instantiating the driver
        driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
        driver.findElement(By.cssSelector("a[href='javascript: void(0);loadAjax();']")).click();
        //Explict wait
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#results")));
        System.out.println(driver.findElement(By.cssSelector("#results")).getText());
        driver.close();
        driver.quit();
    }
}
