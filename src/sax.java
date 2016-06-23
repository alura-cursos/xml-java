import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import sax.ProdutoHandler;

public class sax {
	public static void main(String[] args) throws Exception {
		// codigo que vai converter o xml em objetos produtos
		
		XMLReader reader = XMLReaderFactory.createXMLReader();
		ProdutoHandler ph = new ProdutoHandler();
		reader.setContentHandler(ph);
		
		InputStream is = new FileInputStream("src/venda.xml");
		
		reader.parse(new InputSource(is));
		
		System.out.println(ph.getProdutos());
		
		
		
		
	}
}
