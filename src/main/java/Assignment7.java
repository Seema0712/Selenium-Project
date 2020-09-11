import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

    public static void main(String[] args) {
        //chrome driver
        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver(); //instantiating the driver
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        int rows = driver.findElements(By.xpath("//table[@id='product']/tbody/tr")).size();
        System.out.println("the no. of rows are"+rows);
        int columns = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/th")).size();
        System.out.println("the no. of columns are"+columns);
        String secondContent = driver.findElement(By.xpath("//table[@id='product']/tbody/tr[3]")).getText();
        System.out.println(secondContent);
    }
}
