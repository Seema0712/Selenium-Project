package testing;

import org.testng.annotations.*;

public class Demo2Test {

    @Test(groups = "smoke")
    public void demoMethod() {
        System.out.println("Testng test");
    }

    @Parameters({"url","port"})
    @Test
    public void demoMethod2(String urlName,String portName) {
        System.out.println(urlName+" "+portName);
    }

    @Test(dependsOnMethods = "demoMethod") //it will execute this method first as in testNG tests execute alphabetically
    public void demoMethod3() {
        System.out.println("Testng test3");
    }

    @Test(enabled = false) //if you dont want to execute it
    public void demoMethod4() {
        System.out.println("Testng test4");
    }

    /*@AfterGroups(groups = "smoke")
    public void afterMethod() {
        System.out.println("after method");
    }*/
}
