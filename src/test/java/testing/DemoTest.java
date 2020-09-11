package testing;

import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

public class DemoTest {

    @Test(groups = "smoke")
    public void demoMethod() {
        System.out.println("Testng test");
       // Assert.fail(); if we have to fail the tc
    }

    @Test(timeOut = 5000) //it will wait this much time before starting
    public void demoMethod2() {
        System.out.println("Testng test2");
    }

    @Test(dependsOnMethods = "demoMethod") //it will execute this method first as in testNG tests execute alphabetically
    public void demoMethod3() {
        System.out.println("Testng test3");
    }

    @Test(enabled = false) //if you dont want to execute it
    public void demoMethod4() {
        System.out.println("Testng test4");
    }

    @Parameters({"url","port"})
    @Test
    public void demoMethod5(String urlName,String portName) {
        System.out.println(urlName+" "+portName);
    }

    @Test(dataProvider = "getData")
    public void useData(String un, String pswd) {
        System.out.println(un);
        System.out.println(pswd);
    }

    @DataProvider
    public Object[][] getData() {

        Object [][] data= new Object[3][2];

        //3 sets of data where one set has 2 values

        //1st set
        data[0][0] = "firstUN";
        data[0][1] = "firstPswd";

        //2nd set
        data[1][0] = "secondUN";
        data[1][1] = "secondPswd";

        //3rd setq
        data[2][0] = "thirdUN";
        data[2][1] = "thirdPswd";

        return data;
    }

    //@BeforeClass ://it will execute once before this class methods
    //@BeforeMethod :// for each method it will execute
    //@BeforeTest for entire consists of diff classes it will run once
    //@BeforeSuite ://for entire suite it will execute once same for after also
    //@BeforeGroups(groups = "smoke") //can mention the group before which it needs to be executed


}
