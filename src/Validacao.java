import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Validacao {
	public static void main(String[] args) throws Exception {

//		String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
//		SchemaFactory schemaFactory = SchemaFactory.newInstance(language);
//		Schema schema = schemaFactory.newSchema(new File("src/venda.xsd"));
//		Validator validator = schema.newValidator();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		builder.parse("src/venda.xml");

		System.out.println("rodei");
	}
}
