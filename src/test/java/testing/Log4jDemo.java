package testing;

import org.apache.logging.log4j.*;

public class Log4jDemo {

    private static Logger log = LogManager.getLogger(Log4jDemo.class.getName());

    public static void main(String[] args) {

        //this info dint print as the configuration set as to only print for errors
        //so we need to create our own config file for logging
        log.info("the first step for logging");
        log.error("incorrect object");
        log.fatal("failure occurs");
    }
}
