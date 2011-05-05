package com.augmentum.training.utils;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class XmlUtils {
	public static Document readXml() {
		Document document = null;
		File file = new File("C:/workspace/SimpleIoc/src/Spring.xml");
		try {
			document = (Document) new SAXReader().read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		return document;
	}
}
