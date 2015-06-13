package ua.artcode.week5.day1;


import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by serhii on 23.05.15.
 */
public class TestFileAppender {

    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger("simple");


        logger.addAppender(new FileAppender(new MySimpleLayout(),"/home/serhii/IdeaProjects/ACP6/temp/file.log"));
        logger.info("test simple logger");
    }
}
