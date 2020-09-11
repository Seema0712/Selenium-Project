import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class SortVeggies {

    public static void main(String[] args) {

        WebDriver driver = Demo.instantiatingBrowser();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        List<WebElement> veggies = driver.findElements(By.xpath("//tbody/tr/td[2]")); //with css we can use like this as well= tr td:nth-child(2)
        List<String> veggiesNames = new ArrayList<>();
        List<String> sortedList;
        for (WebElement veggie : veggies) {
            veggiesNames.add(veggie.getText());
        }
        sortedList = veggiesNames;
        //veggiesNames.forEach(str -> System.out.println(str)); //lambda can also be used here
        System.out.println("original"+veggiesNames);
        Collections.sort(sortedList);
        if(sortedList.equals(veggiesNames))
            System.out.println("default list is sorted");
        else
            System.out.println("list is not sorted");
        //clicking on the sort button
        driver.findElement(By.cssSelector("thead tr th:nth-child(2)")).click();
        veggies = driver.findElements(By.xpath("//tbody/tr/td[2]"));
        veggies.forEach(str -> veggiesNames.add(str.getText()));
        if(sortedList.equals(veggiesNames))
            System.out.println("After selecting sort button list is sorted");
        else
            System.out.println("sorting button not working");
        //clicking on the sort button
        driver.findElement(By.cssSelector("thead tr th:nth-child(2)")).click();
        Collections.reverse(sortedList);
        veggies = driver.findElements(By.xpath("//tbody/tr/td[2]"));
        veggies.forEach(str -> veggiesNames.add(str.getText()));
        if(sortedList.equals(veggiesNames))
            System.out.println("After selecting sort button list is sorted in descending order");
        else
            System.out.println("sorting button not working for descending order");
        driver.quit();
    }
}
