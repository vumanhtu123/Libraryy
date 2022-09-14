package net.fpl.Tuvmph18579.webview;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XMLPar {
    public Document getDocument(String xml) throws IOException, SAXException
    {
        Document document = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=null;
        try
        {
            builder = factory.newDocumentBuilder();//tao moi 1 tai lieu
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        InputSource inputSource = new InputSource();
        //tao luong dua du lieu vao doc
        inputSource.setCharacterStream(new StringReader(xml));
        inputSource.setEncoding("UTF-8");
        document = builder.parse(inputSource);//thuc thi
        return document;
    }
    //ham 2: lay title
    //Element -> text
    public String getValue(Element node, String name)
    {
        String result="";
        //lay ve cac phan tu co cung the
        NodeList nodeList = node.getElementsByTagName(name);
        //lay ve text cua phan tu dau tien
        result = getTextOfNode(nodeList.item(0));
        return result;
    }
    //lay ve text cua node
    private  String getTextOfNode(Node node)
    {
        Node con;
        if(node!=null)
        {
            if(node.hasChildNodes())//neu node co con
            {
                //dua vao vong lap doc
                for(con=node.getFirstChild();con!=null; con=con.getNextSibling())
                {
                    if(con.getNodeType()==Node.TEXT_NODE)
                    {
                        return con.getNodeValue();//tra ve ket qua
                    }
                }
            }
        }
        return "";
    }
}
