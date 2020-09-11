package testing;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentDemo {

    ExtentReports extentReports;

    @BeforeTest
    public void config(){
        //Extent reports, extentSparkReporter
        String path = System.getProperty("user.dir")+"/reports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("ExtentDemoResults");
        reporter.config().setDocumentTitle("test results");
        //it will set the path and the config for report
        //to attach it will use extent report

        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Tester", "Seema");
    }

    @Test
    public void demoTest() {

        extentReports.createTest("demoTest");
        //chrome driver
        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downloads//chromedriver");
        WebDriver driver = new ChromeDriver(); //instantiating the driver
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement checkbox = driver.findElement(By.id("checkBoxOption1"));
        checkbox.click();
        System.out.println(checkbox.isSelected());
        checkbox.click();
        System.out.println(checkbox.isSelected());
        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
        driver.quit();
        extentReports.flush();
    }
}
