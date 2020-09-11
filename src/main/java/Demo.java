import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

    public static void main(String[] args) {
        //chrome driver
        WebDriver driver = Demo.instantiatingBrowser();
        //for google.com
        /*driver.get("http://google.com"); //open google.com
        System.out.println(driver.getTitle()); // to get the title in the page
        System.out.println(driver.getCurrentUrl()); //to get the current url
        //System.out.println(driver.getPageSource()); //for getting the page source
        driver.get("http://yahoo.com");
        driver.navigate().back(); //use navigate then use back method
        //driver.navigate().forward(); //use to navigate forward
        driver.close(); //it will close the current browser
        driver.quit(); //it will close all the selenium open browsers*/

        //for facebook.com
        /*driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("hey there");
        driver.findElement(By.name("pass")).sendKeys("yoo");
        driver.findElement(By.linkText("Forgotten account?")).click();*/

        //for salesforce.com using xpath and css
        /*driver.get("https://login.salesforce.com/");
        driver.findElement(By.cssSelector("#username")).sendKeys("djfhkjs");
        driver.findElement(By.cssSelector("#password")).sendKeys("fsdf");
        driver.findElement(By.xpath("//*[@id='Login']")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id='error']")).getText());*/

        //for facebook.com customised xpath and css
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("hey there");
        driver.findElement(By.xpath("//*[@name='pass']")).sendKeys("yoo");
        driver.findElement(By.cssSelector("[value='Log In']")).click();

        driver.close();
    }

    public static WebDriver instantiatingBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver(); //instantiating the driver
        return driver;
    }
}
