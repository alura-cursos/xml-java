import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XsltExemplo {
	
	public static void main(String[] args) throws Exception {
		TransformerFactory factory = TransformerFactory.newInstance();
		
		InputStream template = new FileInputStream("src/template.xsl");
		StreamSource stylesheet = new StreamSource(template);
		Transformer transformer = factory.newTransformer(stylesheet);
		
		InputStream produtos = new FileInputStream("src/venda.xml");
		StreamSource source = new StreamSource(produtos);
		StreamResult result = new StreamResult("src/saida.xml");
		transformer.transform(source, result);
		
	}
}
