import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class GreenKart {

    public static void main(String[] args) throws Exception {
        //chrome driver
        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver(); //instantiating the driver
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(2000);
        List<String> items = Arrays.asList("Brocolli", "Cucumber", "Beetroot");
        List<WebElement> itemList = driver.findElements(By.cssSelector(".product-name"));
        int counter = 0;
        for (int i = 0; i < itemList.size(); i++) {
            String itemName[] = itemList.get(i).getText().split("-");
            if (items.contains(itemName[0].trim())) {
               // driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(); //text was changing from Add to Cart to Added so use another loctor
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                counter++;
                if (counter == items.size())
                    break;
            }
        }
        Thread.sleep(3000);
        driver.quit();
    }
}
