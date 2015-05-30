package ua.artcode.week5.day1;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import java.io.IOException;

/**
 * Created by serhii on 23.05.15.
 */
public class TestParent {

    public static final String FILENAME = "/home/serhii/IdeaProjects/ACP6/temp/parent.log";

    public static void main(String[] args) throws IOException {
        Logger parent = Logger.getLogger("ua");
        parent.addAppender(new FileAppender(new SimpleLayout(), FILENAME));


        Logger child = Logger.getLogger("ua.artcode");
        child.setAdditivity(false);// no link with father
        child.addAppender(new ConsoleAppender(new SimpleLayout()));

        child.info("child message3");

    }
}
