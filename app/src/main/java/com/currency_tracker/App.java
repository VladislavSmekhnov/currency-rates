package com.currency_tracker;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class App {
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                File inputFile = new File("data.xml");
                Document doc = initDoc(inputFile);
                NodeList nList = doc.getElementsByTagName("Valute");
                HashMap<String, Element> charCodeMap = convertNodeListToHashMap(nList);
                printInfo(charCodeMap, args);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            System.err.println("No currency code when starting a Java application!");
        }
    }

    public static HashMap<String, Element> convertNodeListToHashMap(NodeList nList) {
        HashMap<String, Element> map = new HashMap<>();

        for (int i = 0; i < nList.getLength(); ++i) {
            Node node = nList.item(i);
            if (node.hasChildNodes() && node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                String charCode = eElement.getElementsByTagName("CharCode").item(0).getTextContent();
                map.put(charCode, eElement);
            }
        }

        return map;
    }

    public static void printInfo(HashMap<String, Element> charCodeMap, String[] args) {
        // Retrieve and print the currency code for the args[0] if it exists
        Element targetElement = charCodeMap.get(args[0]);

        if (targetElement != null) {
            System.out.println(args[0] + " (" + targetElement.getElementsByTagName("Name").item(0).getTextContent()
                    + "): " + targetElement.getElementsByTagName("Value").item(0).getTextContent());
        } else {
            System.err.println("Currency code for " + args[0] + " not found!");
        }
    }

    public static Document initDoc(File inputFile) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        return doc;
    }
}
