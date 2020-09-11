import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

    public static void main(String[] args) {
        //chrome driver
        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver(); //instantiating the driver
        driver.get("https://www.cleartrip.com/");
        driver.findElement(By.cssSelector(".icon.ir.datePicker"));
        Select adults = new Select(driver.findElement(By.id("Adults")));
        adults.selectByValue("2");
        Select children = new Select(driver.findElement(By.id("Childrens")));
        children.selectByValue("1");
        driver.findElement(By.cssSelector("#MoreOptionsLink")).click();
        driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Indigo");
        driver.findElement(By.id("SearchBtn")).click();
        System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
    }
}
