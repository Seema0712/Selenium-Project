import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WaitsInSelenium {

    public static void main(String[] args) throws Exception{
        //chrome driver
        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver(); //instantiating the driver
        //implicit wait assigned globally and at each step it will wait max 5sec if page loads before 5secs it will not wait until
        //it is readable and can be used for general scenarios but for specific it will not be able to know the difference in terms of performance
        //driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        //Using explicit wait declaration with WebDriverWait class
        Wait wait = new WebDriverWait(driver,5000);
        List<String> items = Arrays.asList("Brocolli", "Cucumber", "Beetroot");
        WaitsInSelenium.AddTocart(driver, items);
        //clicking on car icon
        driver.findElement(By.cssSelector(".cart-icon")).click();
        //click on checkout button
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        //enter the code
        //using explicit wait based on the element visibility
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        //click on apply button
        driver.findElement(By.xpath("//button[text()='Apply']")).click();
        // ========
        //we can use fluent wait which is a class implementing Wait interface with methods Timeout in Duration and polling as well , ignoring method for ignoring the exception and wait for next interval
        Wait<WebDriver> wait1 = new FluentWait(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);
        //we have to write our own function as there are no specific functions available
        wait1.until(driver1 -> {
            if(driver1.findElement(By.xpath("//button[text()='Apply']")).isDisplayed()) //this condition is bcz the element is there but it is not visible
                return driver1.findElement(By.xpath("//button[text()='Apply']"));
            else
                return null;
        });
        //fetching the success message
        System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
        driver.close();
        driver.quit();
    }

    public static void AddTocart(WebDriver driver, List<String> items) throws Exception {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        //just pause the browser driver for given time
        Thread.sleep(2000);
        List<WebElement> itemList = driver.findElements(By.cssSelector(".product-name"));
        int counter = 0;
        for (int i = 0; i < itemList.size(); i++) {
            String itemName[] = itemList.get(i).getText().split("-");
            if (items.contains(itemName[0].trim())) {
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                counter++;
                if (counter == items.size())
                    break;
            }
        }
    }
}
