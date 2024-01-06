package com.java.streams.interview;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLToObjects
{

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
	{
		String input = "<students>" + "<student>" + "<name>arpan</name>" + "<age>13</age>" + "	<id>234</id>"
				+ "</student>" + "<student> " + "<name>babu</name>" + "	<age>13</age>" + "<id>3333</id>" + "</student>"
				+ "</students>	";

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// API to obtain DOM Document instance
		DocumentBuilder builder = null;
			// Create DocumentBuilder with default configuration
			builder = factory.newDocumentBuilder();

			// Parse the content to Document object
			Document doc = builder.parse(new InputSource(new StringReader(input)));

		Map<String, String> xmltext = new HashMap<String, String>();

		NodeList nodeList = doc.getElementsByTagName(doc.getFirstChild().getNodeName());
		for (int i = 0; i < nodeList.getLength(); i++)
		{

			Node node = nodeList.item(i);
		
	      System.out.println("\nNode Name : " + node.getNodeName());
			if (node.getNodeType() == Node.ELEMENT_NODE)
			{
				Element eElement = (Element) node;
				System.out.println("Name: " + eElement.getElementsByTagName("name").item(0).getTextContent());
				System.out.println("Title: " + eElement.getElementsByTagName("title").item(0).getTextContent());

			}
		}

		System.out.println(xmltext);
	}

	public Map<String, String> getMap(NodeList nodeList, Map<String, String> nodeMap)
	{
		if (nodeList.getLength() == 0)
			return nodeMap;

		Map<String, Map<String, String>> result = new HashMap<>();
		return nodeMap;
		
	}

}
