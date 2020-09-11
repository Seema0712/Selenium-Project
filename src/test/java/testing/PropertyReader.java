package testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    public static void main(String[] args) throws IOException {
        Properties pr = new Properties();
        FileInputStream fl = new FileInputStream(new File("src/main/resources/Global.properties"));
        pr.load(fl);
        System.out.println(pr.get("browser"));
        System.out.println(pr.get("url"));
        pr.setProperty("browser", "firefox");
        System.out.println(pr.get("browser")); //this will only set the value here bt not change in properties file
        FileOutputStream fol = new FileOutputStream(new File("src/main/resources/Global.properties"));
        pr.store(fol,null);
    }
}
