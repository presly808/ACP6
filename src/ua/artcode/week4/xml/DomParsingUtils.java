package ua.artcode.week4.xml;

import org.w3c.dom.*;

/**
 * Created by serhii on 17.05.15.import org.w3c.dom.*;

 /**
 * Created by serhii on 10.02.15.
 */
public class DomParsingUtils {

    public static String getTextXMLContent(Element curr) {

        String res = "<" + curr.getTagName() +
                (curr.hasAttributes() ? getAttributes(curr) : "") + ">";

        if (!curr.hasChildNodes()) {
            return "";
        } else {
            NodeList children = curr.getChildNodes();
            String retStr = "";
            for (int i = 0; i < children.getLength(); i++) {
                Node iter = children.item(i);
                if (iter.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) iter;
                    retStr += getTextXMLContent(element);
                } else if (iter.getNodeType() == Node.TEXT_NODE) {
                    Text textNode = (Text) iter;
                    String text = textNode.getTextContent();
                    if (!text.isEmpty()) {
                        retStr += text;
                    }
                }

            }
            res += retStr;
        }

        res += "</" + curr.getTagName() + ">";

        return res;
    }

    private static String getAttributes(Element element) {
        NamedNodeMap map = element.getAttributes();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.getLength(); i++) {
            Attr attr = (Attr) map.item(i);
            sb.append(" ").append(attr.getName()).append("=").append("\"").append(attr.getValue()).append("\"");
        }
        return sb.toString();


    }
}
