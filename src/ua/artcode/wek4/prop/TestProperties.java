package ua.artcode.wek4.prop;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by serhii on 16.05.15.
 */
public class TestProperties {

    public static final String FILE_NAME = "/home/serhii/IdeaProjects/ACP6/temp/";

    public static void main(String[] args) throws IOException {
        testLoading();
        testSaving();
        testSavingXML();
    }

    private static void testLoading() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileReader(FILE_NAME + "game.properties"));
        prop.list(System.out);
    }

    private static void testSaving() throws IOException {
        Properties properties = new Properties();
        properties.put("user.name","Vania");
        properties.put("user.age", "34");

        properties.store(new FileOutputStream(FILE_NAME + "test_save.properties"), "");
    }

    private static void testSavingXML() throws IOException {
        Properties properties = new Properties();
        properties.put("user.name","Vania");
        properties.put("user.age","34");

        properties.storeToXML(new FileOutputStream(FILE_NAME + "test_save.xml"),"");
    }
}
