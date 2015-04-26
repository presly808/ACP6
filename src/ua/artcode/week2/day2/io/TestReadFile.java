package ua.artcode.week2.day2.io;

import java.io.FileNotFoundException;

/**
 * Created by serhii on 26.04.15.
 */
public class TestReadFile {

    public static final String PATH = "/home/serhii/IdeaProjects/ACP6/home/week1.txt";

    public static void main(String[] args) throws FileNotFoundException {
        String content = IOUtils.readFromFileInputStream(PATH);
        System.out.println(content);
    }

}
