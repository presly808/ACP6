package ua.artcode.week4.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Created by serhii on 17.05.15.
 */
public class SaxParserTest {

    public static final String STRING = "/home/serhii/IdeaProjects/ACP6/temp/team.xml";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(STRING, new MySaxHandler());

    }
}

class MySaxHandler extends DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print("<" + qName+ ">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.print("</" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.print(new String(ch,start,length));
    }
}