import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid {

    public static void main(String[] args) throws MalformedURLException {

        //to use selenium grid we need to set hub in one machine and then have to create node in another machine giving IP address of hub machine
        DesiredCapabilities dc = new DesiredCapabilities();
        //dc.setCapability(CapabilityType.BROWSER_NAME,"chrome");
        // or we can do the below way as well
        dc.setBrowserName("chrome");
        dc.setPlatform(Platform.WINDOWS);
        //creating remote webdriver
        WebDriver driver = new RemoteWebDriver(new URL(""),dc); //URL is of the hub where it is running
        driver.get("http://google.com");
    }
}
