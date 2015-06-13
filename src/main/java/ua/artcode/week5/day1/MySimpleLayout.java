package ua.artcode.week5.day1;

import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;

import java.util.Date;

public class MySimpleLayout extends Layout {


    @Override
    public String format(LoggingEvent event) {
        return String.format("%1$td/%1$tm/%1$tY %1$tH:%1$tM:%1$tS - %2$s - %3$s\n",
                                            new Date(event.getTimeStamp()),
                                            event.getLevel(),
                                            event.getMessage());
    }

    @Override
    public boolean ignoresThrowable() {
        return false;
    }

    @Override
    public void activateOptions() {

    }
}
