import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;

public class MIscellaneous {

    public static void main(String[] args) throws Exception{
        //chrome driver
        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver(); //instantiating the driver
        driver.manage().window().maximize(); //to maximize the screen
        //For deleting the cookies
        driver.manage().deleteAllCookies();
        //if you want to delete a particular cookie
        //driver.manage().deleteCookieNamed("Info");
        //if we want to test for session logout then
        //driver.manage().deleteCookieNamed("sessionKey");
        driver.get("https://www.google.com/");
        //to take screenshot
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("//Users//seema//Desktop//SeleniumDocs//Screenshot//screenshot.png"));
        driver.quit();
    }
}
