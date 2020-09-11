import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CricbuzPractice {

    public static void main(String[] args) {
        int sum = 0;
        System.setProperty("webdriver.chrome.driver", "//Users//seema//Downls//chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/22782/nz-vs-ind-2nd-test-india-tour-of-new-zealand-2020");
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        WebElement table = driver.findElement(By.xpath("//div[@id='innings_1']/div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr'][1]"));
//        int tableRows = table.findElements(By.cssSelector("div.cb-col.cb-col-100.cb-scrd-hdr-rw")).size();
        List<WebElement> columnCount = table.findElements(By.cssSelector("div.cb-col.cb-col-100.cb-scrd-itms div:nth-child(3)"));

        for(int i=0;i<columnCount.size()-2;i++)
        {
           sum+=Integer.parseInt(columnCount.get(i).getText());
        }
        sum+=Integer.parseInt(table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText());
        System.out.println(sum);
        int total= Integer.parseInt(table.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText());
        if(sum==total)
            System.out.println("total is correct");
        else
            System.out.println("incorrect");
        driver.quit();
    }
}
