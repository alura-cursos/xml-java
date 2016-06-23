import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Programa {
	
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/venda.xml");
		
		NodeList produtos = document.getElementsByTagName("produto");
		
		for(int i =0; i < produtos.getLength(); i++) {
			Element produto = (Element) produtos.item(i);
			String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
			String preco = produto.getElementsByTagName("preco").item(0).getTextContent();
			
			System.out.println("-----------");
			System.out.println("Nome do produto: "+ nome);
			System.out.println("Preco do produto: "+ preco);
			System.out.println("-----------");
		}
		
	}
	
}
