package org.example.helpers;

import org.example.Address;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class ParserXml extends ParserFile {
    private static final String TAG_ITEM = "item";
    private static final String ATTRIBUTE_CITY = "city";
    private static final String ATTRIBUTE_STREET = "street";
    private static final String ATTRIBUTE_HOUSE = "house";
    private static final String ATTRIBUTE_FLOOR = "floor";

    @Override
    public ArrayList<Address> parse(String path) {
        Document doc;

        try {
            doc = buildDocument(path);
        } catch (Exception e) {
            System.out.println("Ошибка");
            return null;
        }

        Node rootNode = doc.getFirstChild();
        NodeList rootChilds = rootNode.getChildNodes();

        ArrayList<Address> addressList = new ArrayList<>();

        for (int i = 0; i < rootChilds.getLength(); i++) {
            if (rootChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            switch (rootChilds.item(i).getNodeName()) {
                case TAG_ITEM:
                    String city = rootChilds.item(i).getAttributes().getNamedItem(ATTRIBUTE_CITY).getNodeValue();
                    String street = rootChilds.item(i).getAttributes().getNamedItem(ATTRIBUTE_STREET).getNodeValue();
                    int house = Integer.parseInt(rootChilds.item(i).getAttributes().getNamedItem(ATTRIBUTE_HOUSE).getNodeValue());
                    int floor = Integer.parseInt(rootChilds.item(i).getAttributes().getNamedItem(ATTRIBUTE_FLOOR).getNodeValue());
                    addressList.add(new Address(city, street, house, floor));
                    break;
            }
        }

        return addressList;
    }

    public Document buildDocument(String path) throws Exception {
        File file = new File("src/main/resources/" + path);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        return dbf.newDocumentBuilder().parse(file);
    }
}
