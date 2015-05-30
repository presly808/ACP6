package ua.artcode.week5.day1;

import org.apache.log4j.*;


/**
 * Created by serhii on 23.05.15.
 */
public class TestLoggerSimple {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("main");

        logger.setLevel(Level.INFO);

        Layout layout = new SimpleLayout();

        Appender appender = new ConsoleAppender(layout);

        logger.addAppender(appender);

        logger.debug("program starts");


    }
}
